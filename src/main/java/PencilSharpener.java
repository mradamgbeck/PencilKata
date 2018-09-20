public class PencilSharpener {

    public Pencil sharpen(Pencil pencil) {
        if (pencil.getLength() > 0) {
            pencil.setLength(pencil.getLength() - 1);
            pencil.setCurrentSharpness(pencil.getOriginalSharpness());
        }
        return pencil;
    }
}
