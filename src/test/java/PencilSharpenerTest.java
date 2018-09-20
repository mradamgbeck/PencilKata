import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PencilSharpenerTest {

    @Mock
    private Pencil mockPencil;
    private PencilSharpener sharpener;
    private int originalSharpness;
    private int originalLength;

    @Before
    public void setup() {
        originalSharpness = 10;
        originalLength = 3;
        sharpener = new PencilSharpener();
        when(mockPencil.getOriginalSharpness()).thenReturn(originalSharpness);
        when(mockPencil.getLength()).thenReturn(originalLength);
    }

    @Test
    public void sharpenResetsPencilSharpnessToOriginalSharpness() {
        sharpener.sharpen(mockPencil);
        verify(mockPencil).setCurrentSharpness(originalSharpness);
    }

    @Test
    public void sharpenDecrementsPencilLength() {
        sharpener.sharpen(mockPencil);
        verify(mockPencil).setLength(originalLength - 1);
    }

    @Test
    public void sharpenDoesNotResetSharpnessIfLengthIsZero() {
        when(mockPencil.getLength()).thenReturn(0);
        sharpener.sharpen(mockPencil);
        verify(mockPencil, never()).setCurrentSharpness(originalSharpness);
    }
}
