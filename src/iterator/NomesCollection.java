package iterator;

public class NomesCollection implements Container {
    public String nomes[] = {"Alex" , "Anderson" ,"Julio" , "Mari", "Vini"};

    @Override
    public Iterator getIterator() {
        return new NomeIterator();
    }

    private class NomeIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if(index < nomes.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return nomes[index++];
            }
            return null;
        }
    }
}
