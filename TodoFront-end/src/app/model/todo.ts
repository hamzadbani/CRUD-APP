export class Todo {
    id : number;
    task: string;
    date: Date;
    done: boolean;

  constructor(){
    this.id = 0;
    this.task = "";
    this.date =new Date('2017-04-17T03:24:00');
    this.done = false;
  }
}
