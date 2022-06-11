import org.mockito.Mockito.*;

class Mock {
    public static void main(String [] args) {
        ContactService service = mock(ContactService.class);
        when(service.add(2, 3)).thenReturn(5);
        assertEquals(5, 5)
        verify(service).add(2, 3)
    }
}