import { Body, Controller, Delete, Get, Param, Post, Put, Req, UploadedFile, UseGuards, UseInterceptors } from '@nestjs/common';
import { FileInterceptor } from '@nestjs/platform-express';
import { ApiConsumes, ApiOkResponse, ApiTags } from '@nestjs/swagger';
import { plainToClass } from 'class-transformer';
import { JwtAuthGuard } from 'src/auth/guards/jwt-auth.guard';
import { CommentsService } from 'src/comments/comments.service';
import { CreateCommentDto } from 'src/comments/dto/create-comment.dto';
import { CreatePostingDto } from './dto/create-posting.dto';
import { ReturnPostingDto } from './dto/return-posting.dto';
import { UpdatePostingDto } from './dto/update-posting.dto';
import { Posting } from './entities/posting.entity';
import { PostingsService } from './postings.service';

@ApiTags('postings')
@Controller('postings')
export class PostingsController {
  constructor(private postingsService: PostingsService, private commentsService: CommentsService) {}

  @Get()
  @ApiOkResponse({ type: Posting, isArray: true })
  async getAllPostings(): Promise<ReturnPostingDto[]> {
    const postings = await this.postingsService.getAll();
    return plainToClass(ReturnPostingDto, postings);
  }

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

  @Get('/category/:category')
  async getPostingsCategory(@Param('category') category: string): Promise<ReturnPostingDto[]> {
    const postings = await this.postingsService.getAllByCategory(category);
    return plainToClass(ReturnPostingDto, postings);
  }

  @Get('/:id')
  async getPosting(@Param('id') id: number): Promise<ReturnPostingDto> {
    const posting = await this.postingsService.getOneById(id);
    return plainToClass(ReturnPostingDto, posting);
  }

  @UseGuards(JwtAuthGuard)
  @Put('/:id')
  async editPosting(@Param('id') id: number, @Body() body: UpdatePostingDto): Promise<ReturnPostingDto> {
    const posting = await this.postingsService.updatePosting(id, body);
    return plainToClass(ReturnPostingDto, posting);
  }

  @UseGuards(JwtAuthGuard)
  @Delete('/:id')
  async deletePosting(@Param('id') id: number): Promise<ReturnPostingDto> {
    const posting = await this.postingsService.deletePosting(id);
    return plainToClass(ReturnPostingDto, posting);
  }

  @UseGuards(JwtAuthGuard)
  @Post('/:id/comments')
  async createComment(@Param('id') postId: number, @Req() req, @Body() body: CreateCommentDto): Promise<ReturnPostingDto> {
    const posting = await this.postingsService.getOneById(postId);
    const comment = await this.commentsService.createComment(req.user.id, body, posting);
    return this.getPosting(postId);
  }

  @UseGuards(JwtAuthGuard)
  @Delete(':id/comments/:commentId')
  async deleteComment(@Param('id') postId: number, @Param('commentId') commentId: number): Promise<ReturnPostingDto> {
    const comment = await this.commentsService.deleteComment(commentId);
    return this.getPosting(postId);
  }

  @UseGuards(JwtAuthGuard)
  @Get('/:id/comments/:commentId/like')
  async likeComment(@Param('id') postId: number, @Param('commentId') commentId: number, @Req() req) {
    const comment = await this.commentsService.likeComment(commentId, req.user.email);
    return this.getPosting(postId);
  }
}
