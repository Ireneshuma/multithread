public class mythread implements Runnable{
    Thread thread;
    mythread(String name){
        thread = new Thread(this ,name);
    }
    public static mythread createAndStart(String name) {
        mythread mythread = new mythread(name);
        mythread.thread.start();
        return mythread;


    }
    public void run(){
        System.out.println(thread.getName() + "starts to operate");
        try{
            for(int count = 0;count < 10;count++) {
                Thread.sleep(100);
                System.out.println(thread.getName() + "is executed , the counter value" + count);
            }
            }
            catch (InterruptedException e ){
                System.out.println(thread.getName() + "has been interrupted");
            }
            System.out.println(thread.getName() + "finishes running ");

    }
}
class multithread{
    public static void main(String[] args) {
        System.out.println("The main thread starts running ");
        mythread mythread1 = mythread.createAndStart("Child thread no 1");
        mythread mythread2 = mythread.createAndStart("Child thread no 2");
        mythread mythread3 = mythread.createAndStart("child thread no 3");

        System.out.print(".");
        try{
            mythread1.thread.join();
            mythread2.thread.join();
            mythread3.thread.join();
        }
        catch (InterruptedException e){
            System.out.println("The main thread has been terminated");
        }
        System.out.println();
    }


}