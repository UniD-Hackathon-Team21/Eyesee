import { ApiProperty } from '@nestjs/swagger';
import { Exclude, Expose } from 'class-transformer';

@Exclude()
export class ReturnPostingDto {
  @ApiProperty()
  @Expose()
  userId: number;

  @ApiProperty()
  @Expose()
  text: string;

  @ApiProperty()
  @Expose()
  imgPath: string;

  @ApiProperty()
  @Expose()
  category: string;

  @ApiProperty({ type: () => Comment, isArray: true, nullable: true })
  @Expose()
  comments: Comment[];

  @ApiProperty()
  @Expose()
  createdAt: Date;
}