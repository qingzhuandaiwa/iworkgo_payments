package com.yk.iworkgo.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.baomidou.mybatisplus.plugins.Page;
import lombok.Data;

import java.util.Collection;

@Data
public class PageVO<E> {

  public static final String KEY_PAGE_FROM = "pageFrom";

  public static final String KEY_PAGE_SIZE = "pageSize";

  public static final int DEFAULT_PAGE_SIZE = 10;
  public static final int DEFAULT_PAGE_FROM = 1;


  /**
   * 总条数
   */
  private long total;

  /* 当前页 */
  private long current;

  /* 总页数 */
  private long pages;

  /* 每页显示条数 */
  private long size;

  /**
   * 查询结果
   */
  private Collection<E> rows;

  public PageVO() {
  }

  public PageVO(Collection<E> rows, int total, int pages, int current, int size) {
    this.rows = rows;
    this.total = total;
    this.pages = pages;
    this.current = current;
    this.size = size;
  }

  public PageVO(Collection<E> rows, Page page){
    this.rows = rows;
    this.total = page.getTotal();
    this.pages = page.getPages();
    this.current = page.getCurrent();
    this.size = page.getSize();
  }

}