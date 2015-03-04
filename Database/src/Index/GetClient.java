package Index;
/*************************************************************************
 * 
 *	Author: Zishan Qin & Yan Wang 
 *	
 *  Project2: Index
 *  
 *  Implementation choice: B+ tree
 *  
 *  Data source: NSF Research Awards Abstracts 1990-2003(ICS Department, School of Computer Science, UCI, Irvine CA, 92697, USA),
 *  part3-a list of words for indexing the bag-of-word data.
 *
 *************************************************************************/

public class GetClient <Key extends Comparable<Key>, Value>implements Runnable{
	   private Thread getThread;
	   private String threadName;
	   private Key key;
	   private BTree btr;
	   
	   GetClient( String name, BTree btree, Key key){
	       threadName = name;
	       this.key = key;
	       btr=btree;
	       getThread = new Thread (this, threadName);
	       getThread.start ();
	   }
	   public void run() {
		   	Value value=(Value) btr.get(key);
        	if(value!=null){
        		System.out.println(threadName+"  get value "+value+" with key "+ key);
        	}
        	else{
        		System.out.println(threadName+" try to get value with key "+ key+", but not found");
        	}
		}
         
}
