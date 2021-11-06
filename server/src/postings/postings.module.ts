import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { AuthModule } from 'src/auth/auth.module';
import { CommentsModule } from 'src/comments/comments.module';
import { Posting } from './entities/posting.entity';
import { PostingsController } from './postings.controller';
import { PostingsService } from './postings.service';

@Module({
  imports: [TypeOrmModule.forFeature([Posting]), AuthModule, CommentsModule],
  controllers: [PostingsController],
  providers: [PostingsService],
})
export class PostingsModule {}
