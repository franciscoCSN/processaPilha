package ContainerClass;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplFilhaThread extends Thread{
	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_filha = 
			new ConcurrentLinkedQueue<ObjetoFilaThread>(); 

	public static void add(ObjetoFilaThread objetoFilaThread) {
		pilha_filha.add(objetoFilaThread);
	}

	@Override
	public void run() {

		System.out.println("Thread rodando no sistema.");
		while(true) {
			synchronized (pilha_filha) {
				Iterator iteracao = pilha_filha.iterator();
				while(iteracao.hasNext()) {
					ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next(); //pega o objeto atual
					/*
					 * 
					 *implementa processos longos 
					 *
					 */
					System.out.println("================================");
					System.out.println(processar.getNome());
					System.out.println(processar.getEmail());

					iteracao.remove();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


//	@Override
//	public synchronized void start() {
//		// TODO Auto-generated method stub
//		super.start();
//	}

}
