class MyString implements Appendable {

    @Override
    public Appendable append(Appendable a) {
        this.append(a);
        return this;
    }
}
