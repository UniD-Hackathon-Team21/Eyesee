import { HttpException, HttpStatus, Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { UsersService } from 'src/users/users.service';
import { Repository } from 'typeorm';
import { UpdatePostingDto } from './dto/update-posting.dto';
import { Posting } from './entities/posting.entity';
@Injectable()
export class PostingsService {
  constructor(@InjectRepository(Posting) private postingsRepository: Repository<Posting>, private usersService: UsersService) {}

  async getAll(): Promise<Posting[]> {
    return this.postingsRepository.find({ relations: ['comments'] });
  }

  async getAllByCategory(category: string): Promise<Posting[]> {
    return this.postingsRepository.find({ where: { category }, relations: ['comments'] });
  }

  async getOneById(id: number): Promise<Posting | null> {
    try {
      const posting = await this.postingsRepository.findOneOrFail({ id }, { relations: ['comments'] });
      return posting;
    } catch (err) {
      return null;
    }
  }

  async createPosting(text: string, category: string, imgPath: string, userId: number): Promise<Posting> {
    const newPosting = this.postingsRepository.create({ text, category, imgPath, userId });
    await this.usersService.addPoints(userId, 1);
    return await this.postingsRepository.save(newPosting);
  }

  async updatePosting(id: number, updatePostingDto: UpdatePostingDto): Promise<any> {
    const posting = this.getOneById(id);
    if (posting) {
      return await this.postingsRepository.save(Object.assign(posting, updatePostingDto));
    } else {
      throw new HttpException('Posting not found', HttpStatus.NOT_FOUND);
    }
  }

  async deletePosting(id: number): Promise<Posting> {
    const posting = await this.getOneById(id);
    return await this.postingsRepository.remove(posting);
  }
}
