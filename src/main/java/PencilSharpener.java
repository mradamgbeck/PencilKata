public class PencilSharpener {
    public Pencil sharpen(Pencil pencil) {
        pencil.setCurrentSharpness(pencil.getOriginalSharpness());
        pencil.setLength(pencil.getLength()-1);
        return pencil;
    }
}
