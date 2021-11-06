import { Module } from '@nestjs/common';
import { CommentsService } from './comments.service';
import { Comment } from './entities/comment.entity';
import { AuthModule } from 'src/auth/auth.module';
import { TypeOrmModule } from '@nestjs/typeorm';

@Module({
  imports: [TypeOrmModule.forFeature([Comment]), AuthModule],
  providers: [CommentsService],
  exports: [CommentsService],
})
export class CommentsModule {}
