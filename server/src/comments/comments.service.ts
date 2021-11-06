import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Posting } from 'src/postings/entities/posting.entity';
import { Comment } from './entities/comment.entity';
import { Repository } from 'typeorm';
import { CreateCommentDto } from './dto/create-comment.dto';

@Injectable()
export class CommentsService {
  constructor(@InjectRepository(Comment) private commentsRepository: Repository<Comment>) {}

  async getOneById(id: number): Promise<Comment | null> {
    try {
      const comment = await this.commentsRepository.findOneOrFail({ id });
      return comment;
    } catch (err) {
      return null;
    }
  }

  async createComment(userId: number, createCommentDto: CreateCommentDto, posting: Posting): Promise<Comment> {
    const newComment = await this.commentsRepository.create({ userId, content: createCommentDto.content, posting });
    return await this.commentsRepository.save(newComment);
  }

  async deleteComment(id: number) {
    const comment = await this.getOneById(id);
    return await this.commentsRepository.remove(comment);
  }
}
