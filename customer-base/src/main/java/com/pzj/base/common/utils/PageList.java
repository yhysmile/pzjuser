package com.pzj.base.common.utils;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 分页处理对象
 * 
 * 项目名称：service.product.redis 类名称：PageList 类描述： 创建人：石月 创建时间：2014-6-14 下午2:26:23
 * 修改人：石月 修改时间：2014-6-14 下午2:26:23 修改备注：
 * 
 * @version
 * 
 */
public class PageList<T> implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    /**
     * 存放结果集
     */
    private List<T> resultList;

    /**
     * 分页信息
     */
    private PageBean pageBean;

    /**
     * 带参构造方法
     * 
     * @param resultList
     *            结果集
     * @param pageBean
     *            分页信息
     */
    public PageList(List<T> resultList, PageBean pageBean) {
        this.resultList = resultList;
        this.pageBean = pageBean;
    }

    public PageList(List<T> resultList, PageModel pager, long totalCount) {
        this.resultList = resultList;
        PageBean p = new PageBean(totalCount, pager);
        this.pageBean = p;
    }

    public PageList() {
    }

    /**
     * 得到结果集中的元素
     * 
     * @author FengJianBo
     * @param index
     *            下标
     * @return 2014年3月21日 下午4:39:14
     */
    public T get(int index) {
        return resultList.get(index);
    }

    /**
     * 判断结果集是否为空
     * 
     * @author FengJianBo
     * @return 2014年3月21日 下午4:38:22
     */
    public boolean isEmpty() {
        if (this.resultList == null || this.resultList.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 获取存储的结果集
     * 
     * @author FengJianBo
     * @return 2014年3月21日 下午4:31:38
     */
    public List<T> getResultList() {
        return resultList;
    }

    /**
     * 设置存放的结果集
     * 
     * @author FengJianBo
     * @return 2014年3月21日 下午4:31:38
     */
    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    /**
     * 获取分页信息
     * 
     * @author FengJianBo
     * @return 2014年3月21日 下午4:32:10
     */
    public PageBean getPageBean() {
        return pageBean;
    }

    /**
     * 设置分页信息
     * 
     * @author FengJianBo
     * @param pageBean
     *            2014年3月21日 下午4:32:20
     */
    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
