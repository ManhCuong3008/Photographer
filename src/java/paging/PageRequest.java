package paging;

/**
 *
 * @author NguyenManhCuong
 */
public class PageRequest {

    private Integer page;
    private Integer maxPageItem;
    
    public PageRequest() {
    }

    public PageRequest(Integer page, Integer maxPageItem) {
        this.page = page;
        this.maxPageItem = maxPageItem;
    }

     public Integer getPage() {
        if (this.page == null) {
            return 1;
        }
        return this.page;
    }

    public Integer getOffset() {
        if (this.page != null && this.maxPageItem != null) {
            return (this.page - 1) * this.maxPageItem;
        } else {
            return 0;
        }
    }

    public Integer getLimit() {
        if (this.maxPageItem == null) {
            return 4;
        }
        return this.maxPageItem;
    }
}
