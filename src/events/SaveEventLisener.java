package events;

import org.springframework.context.ApplicationListener;

public class SaveEventLisener implements ApplicationListener<SaveEvent>{
	
	public void onApplicationEvent(SaveEvent arg0) {
		System.out.println("Zapisano obiekt do bazy: " + arg0.getObject());
	}


}
