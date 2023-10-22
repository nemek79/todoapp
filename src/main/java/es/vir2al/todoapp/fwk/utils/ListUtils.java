package es.vir2al.todoapp.fwk.utils;

import java.util.List;

import org.springframework.lang.Nullable;

public class ListUtils {

    /**
	 * Comprueba si la lista que se pasa por parámetro es nula o vacía
     * @param <T>
	 */
	public static <T> boolean isEmpty(@Nullable List<T> lst) {
		
		return (lst == null || lst.isEmpty() || lst.size() == 0);
	
	}

}
