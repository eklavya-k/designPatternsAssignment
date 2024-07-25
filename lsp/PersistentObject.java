package net.media.training.live.lsp;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 11, 2011
 * Time: 12:56:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersistentObject<T> {
    private T data;

    public PersistentObject(T data){
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    public boolean equals(PersistentObject<T> other) {
        return this.data.equals(other.data);
    }

    public void serialize() {

    }

    public void deSerialize() {

    }
}
