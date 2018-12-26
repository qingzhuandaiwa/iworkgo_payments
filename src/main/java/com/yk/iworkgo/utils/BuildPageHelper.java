package com.yk.iworkgo.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yk.iworkgo.common.PageVO;
import org.springframework.util.StringUtils;

import java.util.Map;

public class BuildPageHelper {

    public static Page buildPage(Map<String, String> condition) {
        int currPage = PageVO.DEFAULT_PAGE_FROM;
        int pageSize = PageVO.DEFAULT_PAGE_SIZE;
        if (!StringUtils.isEmpty(condition.get(PageVO.KEY_PAGE_SIZE))
                && !StringUtils.isEmpty(condition.get(PageVO.KEY_PAGE_FROM))) {
            currPage = Integer.parseInt(condition.get(PageVO.KEY_PAGE_FROM));
            pageSize = Integer.parseInt(condition.get(PageVO.KEY_PAGE_SIZE));
        }

        return new Page(currPage, pageSize);
    }
}
