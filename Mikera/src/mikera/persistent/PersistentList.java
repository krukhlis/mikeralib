package mikera.persistent;

import java.io.Serializable;
import java.util.List;

public interface PersistentList<T> extends PersistentCollection<T>, List<T>, Comparable<PersistentList<T>> {
	public T get(int i);
	
	public PersistentList<T> append(T value);

	public PersistentList<T> append(PersistentList<T> value);
	
	public PersistentList<T> delete(int index);
	
	public PersistentList<T> delete(int start, int end);

	public PersistentList<T> deleteFirst(T value);

	
}