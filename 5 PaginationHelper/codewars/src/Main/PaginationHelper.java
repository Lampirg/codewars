package Main;

import java.util.List;

public class PaginationHelper<I> {

    private final int pageCount;
    private final int lastPageItemCount;
    private final int itemCount;
    private final int itemsPerPage;

    /**
     * The constructor takes in an array of items and an integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        if (itemsPerPage < 0 || itemsPerPage == 0 && collection.size() > 0)
            throw new IllegalArgumentException("invalid itemsPerPage");
        if (itemsPerPage == 0) {
            itemCount = 0;
            this.itemsPerPage = 0;
            pageCount = 0;
            lastPageItemCount = 0;
            return;
        }

        itemCount = collection.size();
        this.itemsPerPage = itemsPerPage;
        pageCount = (int) Math.ceil((double) collection.size() / itemsPerPage);
        lastPageItemCount = collection.size() % itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return itemCount;
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return pageCount;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        final int INDEX_ACCOUNTER = 1;
        if (pageIndex > pageCount - INDEX_ACCOUNTER || pageIndex < 0)
            return -1;
        if (pageIndex == pageCount - INDEX_ACCOUNTER)
            return lastPageItemCount;
        return itemsPerPage;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        final int INDEX_ACCOUNTER = 1;
        itemIndex += INDEX_ACCOUNTER;
        if (itemIndex > itemCount || itemIndex < 0)
            return -1;
        return (int) Math.ceil((double) itemIndex / itemsPerPage) - 1;
    }
}