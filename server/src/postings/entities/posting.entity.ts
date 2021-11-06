import { ApiProperty } from '@nestjs/swagger';
import { BaseEntity, Column, CreateDateColumn, Entity, OneToMany, PrimaryGeneratedColumn } from 'typeorm';
import { Comment } from '../../comments/entities/comment.entity';

@Entity({ name: 'postings' })
export class Posting extends BaseEntity {
  @ApiProperty()
  @PrimaryGeneratedColumn()
  id: number;

  @ApiProperty()
  @Column()
  userId: number;

  @ApiProperty()
  @Column()
  text: string;

  @ApiProperty()
  @Column({ nullable: true })
  imgPath: string;

  @ApiProperty()
  @Column()
  category: string;

  @ApiProperty()
  @Column({ default: 0 })
  reports: number;

  @ApiProperty({ type: () => Comment, isArray: true })
  @OneToMany((type) => Comment, (comment) => comment.posting, { cascade: true })
  comments: Comment[];

  @ApiProperty()
  @CreateDateColumn()
  createdAt: Date;
}
