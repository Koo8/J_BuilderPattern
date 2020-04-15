package InputOutput;

import java.io.Serializable;

// to serialize a class so that its content can be saved(outputstream) and retrieved(inputstream)
public class SimpleObject implements Serializable {
    private String contents;
    private int m,n,p;

    public SimpleObject(String contents, int m, int n, int p) {
        this.contents = contents;
        this.m = m;
        this.n = n;
        this.p = p;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "SimpleObject{" +
                "contents='" + contents + '\'' +
                ", m=" + m +
                ", n=" + n +
                ", p=" + p +
                '}';
    }
}
