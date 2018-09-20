import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PencilSharpenerTest {

    @Mock
    private Pencil mockPencil;
    private PencilSharpener sharpener;
    private int originalSharpness;

    @Before
    public void setup() {
        originalSharpness = 10;
        sharpener = new PencilSharpener();
        when(mockPencil.getOriginalSharpness()).thenReturn(originalSharpness);
    }

    @Test
    public void sharpenResetsPencilSharpnessToOriginalSharpness() {
        sharpener.sharpen(mockPencil);
        verify(mockPencil).setCurrentSharpness(originalSharpness);
    }
}
