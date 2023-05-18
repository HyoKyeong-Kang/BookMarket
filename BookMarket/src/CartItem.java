public class CartItem {
    private String bookId;
    private String bookTitle;
    private int quantity;
    private int totalPrice;

    public CartItem(String bookId, String bookTitle, int quantity) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.quantity = quantity;
        this.totalPrice = 0;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        calculateTotalPrice();
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    private void calculateTotalPrice() {
        int bookPrice = 0;
        totalPrice = bookPrice * quantity;
    }
}
