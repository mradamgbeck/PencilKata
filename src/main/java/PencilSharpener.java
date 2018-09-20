public class PencilSharpener {
    public Pencil sharpen(Pencil pencil) {
        pencil.setCurrentSharpness(pencil.getOriginalSharpness());
        return pencil;
    }
}
