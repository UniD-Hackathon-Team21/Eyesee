import { Body, Controller, Delete, Get, Param, Post, Put, Req, UploadedFile, UseGuards, UseInterceptors } from '@nestjs/common';
import { FileInterceptor } from '@nestjs/platform-express';
import { ApiConsumes, ApiOkResponse, ApiTags } from '@nestjs/swagger';
import { plainToClass } from 'class-transformer';
import { JwtAuthGuard } from 'src/auth/guards/jwt-auth.guard';
import { CreatePostingDto } from './dto/create-posting.dto';
import { ReturnPostingDto } from './dto/return-posting.dto';
import { UpdatePostingDto } from './dto/update-posting.dto';
import { Posting } from './entities/posting.entity';
import { PostingsService } from './postings.service';

@ApiTags('postings')
@Controller('postings')
export class PostingsController {
  constructor(private postingsService: PostingsService) {}

  @UseGuards(JwtAuthGuard)
  @Post()
  @UseInterceptors(
    FileInterceptor('image', {
      dest: './uploads',
    }),
  )
  @ApiConsumes('multipart/form-data')
  @ApiOkResponse({ type: Posting })
  async createPosting(@Req() req, @UploadedFile() file: Express.Multer.File, @Body() body: CreatePostingDto): Promise<ReturnPostingDto> {
    const posting = await this.postingsService.createPosting(body.text, body.category, file.path, req.user.id);
    return plainToClass(ReturnPostingDto, posting);
  }

  @Get('/:id')
  async getPosting(@Param('id') id: number): Promise<ReturnPostingDto> {
    const posting = await this.postingsService.getOneById(id);
    return plainToClass(ReturnPostingDto, posting);
  }

  @Put('/:id')
  async editPosting(@Param('id') id: number, @Body() body: UpdatePostingDto): Promise<ReturnPostingDto> {
    const posting = await this.postingsService.updatePosting(id, body);
    return plainToClass(ReturnPostingDto, posting);
  }

  @Delete('/:id')
  async deletePosting(@Param('id') id: number): Promise<ReturnPostingDto> {
    const posting = await this.deletePosting(id);
    return plainToClass(ReturnPostingDto, posting);
  }
}
