import { Column, Entity, PrimaryGeneratedColumn } from 'typeorm';

@Entity()
export class Organization {
  @PrimaryGeneratedColumn()
  id: string
  @Column()
  name: string
  @Column()
  address: string
  @Column()
  phoneNumber: number
}

