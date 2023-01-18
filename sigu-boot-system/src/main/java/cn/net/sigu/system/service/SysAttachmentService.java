package cn.net.sigu.system.service;

import cn.net.sigu.framework.common.page.PageResult;
import cn.net.sigu.framework.common.service.BaseService;
import cn.net.sigu.system.entity.SysAttachmentEntity;
import cn.net.sigu.system.query.SysAttachmentQuery;
import cn.net.sigu.system.vo.SysAttachmentVO;

import java.util.List;

/**
 * 附件管理
 *
 * @author 阿沐 babamu@126.com
 */
public interface SysAttachmentService extends BaseService<SysAttachmentEntity> {

    PageResult<SysAttachmentVO> page(SysAttachmentQuery query);

    void save(SysAttachmentVO vo);

    void update(SysAttachmentVO vo);

    void delete(List<Long> idList);
}