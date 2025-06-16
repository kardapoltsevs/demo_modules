package com.example.confl;

import com.example.confl.model.Item;
import com.example.confl.repository.ItemRepository;
import com.example.confl.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Test
    void getItemById_ItemExists_ReturnsItem() {
        // Arrange
        Long itemId = 1L;
        Item mockItem = new Item(itemId, "Laptop", 999.99);
        when(itemRepository.findById(itemId)).thenReturn(Optional.of(mockItem));

        // Act
        Item result = itemService.getItemById(itemId);

        // Assert
        assertNotNull(result);
        assertEquals(itemId, result.getId());
        assertEquals("Laptop", result.getName());
        verify(itemRepository, times(1)).findById(itemId);
    }

    @Test
    void getItemById_ItemNotExists_ThrowsException() {
        // Arrange
        Long itemId = 999L;
        when(itemRepository.findById(itemId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> itemService.getItemById(itemId));
    }
}
