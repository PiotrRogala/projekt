package events;

import org.springframework.context.ApplicationEvent;

public class SaveEvent extends ApplicationEvent{
	
	private Object object;

	public SaveEvent(Object object) {
		super(object);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}
