package com.cumt.video.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cumt.video.data.pojo.Videos;
import com.cumt.video.dataobject.Bgm;
import com.cumt.video.dataobject.BgmExample;
import com.cumt.video.service.VideoService;
import com.cumt.video.util.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class VideoServiceImpl implements VideoService {


	
	@Override
	public PagedResult queryReportList(Integer page, Integer pageSize) {

		/*PageHelper.startPage(page, pageSize);

		List<Reports> reportsList = usersReportMapperCustom.selectAllVideoReport();

		PageInfo<Reports> pageList = new PageInfo<Reports>(reportsList);

		PagedResult grid = new PagedResult();
		grid.setTotal(pageList.getPages());
		grid.setRows(reportsList);
		grid.setPage(page);
		grid.setRecords(pageList.getTotal());*/
		PagedResult grid = new PagedResult();

		return grid;
	}

	@Override
	public void updateVideoStatus(String videoId, Integer status) {
		
		Videos video = new Videos();
		video.setId(videoId);
		video.setStatus(status);
	}

	@Override
	public PagedResult queryBgmList(Integer page, Integer pageSize) {
		
		/*PageHelper.startPage(page, pageSize);
		BgmExample example = new BgmExample();
		List<Bgm> list = bgmMapper.selectByExample(example);
		PageInfo<Bgm> pageList = new PageInfo<>(list);
		PagedResult result = new PagedResult();
		result.setTotal(pageList.getPages());
		result.setRows(list);
		result.setPage(page);
		result.setRecords(pageList.getTotal());*/
		PagedResult result = new PagedResult();

		return result;
	}

	@Override
	public void addBgm(Bgm bgm) {
		/*String bgmId = sid.nextShort();
		bgm.setId(bgmId);
		bgmMapper.insert(bgm);
		
		Map<String, String> map = new HashMap<>();
		map.put("operType", BGMOperatorTypeEnum.ADD.type);
		map.put("path", bgm.getPath());
		
		zkCurator.sendBgmOperator(bgmId, JsonUtils.objectToJson(map));*/
	}
	
	@Override
	public void deleteBgm(String id) {
	/*	Bgm bgm = bgmMapper.selectByPrimaryKey(id);
		
		bgmMapper.deleteByPrimaryKey(id);
		
		Map<String, String> map = new HashMap<>();
		map.put("operType", BGMOperatorTypeEnum.DELETE.type);
		map.put("path", bgm.getPath());
		
		zkCurator.sendBgmOperator(id, JsonUtils.objectToJson(map));*/
		
	}

}
