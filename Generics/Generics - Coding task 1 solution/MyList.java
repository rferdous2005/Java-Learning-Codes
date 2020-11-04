class MyList implements Appendable<MyList> {

    @Override
    public Appendable<MyList> append(MyList a) {
        this.append(a);
        return this;
    }

}
