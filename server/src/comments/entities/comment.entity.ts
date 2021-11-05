import { ApiProperty } from '@nestjs/swagger';
import { BaseEntity, Column, CreateDateColumn, Entity, ManyToOne, PrimaryGeneratedColumn } from 'typeorm';
import { Posting } from '../../postings/entities/posting.entity';

@Entity({ name: 'comment' })
export class Comment extends BaseEntity {
  @ApiProperty()
  @PrimaryGeneratedColumn()
  id: number;

  @ApiProperty()
  @Column()
  userId: number;

  @ApiProperty()
  @Column()
  content: string;

  @ApiProperty({ type: () => Posting })
  @ManyToOne((type) => Posting, (posting) => posting.comments)
  posting: Posting;

  @ApiProperty()
  @CreateDateColumn()
  createdAt: Date;
}
