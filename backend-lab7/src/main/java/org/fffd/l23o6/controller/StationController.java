package org.fffd.l23o6.controller;

import java.util.List;
import io.github.lyc8503.spring.starter.incantation.pojo.CommonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.fffd.l23o6.pojo.vo.station.AddStationRequest;
import org.fffd.l23o6.pojo.vo.station.StationVO;
import org.fffd.l23o6.service.StationService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/v1/")
@RequiredArgsConstructor
public class StationController {
    private final StationService stationService;

    @GetMapping("station")
    public CommonResponse<List<StationVO>> listStations() {
        return CommonResponse.success(stationService.listStations());
    }

    @GetMapping("station/{stationId}")
    public CommonResponse<StationVO> getStation(@PathVariable Long stationId) {
        return CommonResponse.success(stationService.getStation(stationId));
    }

    @PostMapping("admin/station")
    public CommonResponse<?> addStation(@Valid @RequestBody AddStationRequest request) {
        stationService.addStation(request.getName());
        return CommonResponse.success();
    }

    @PutMapping("admin/station/{stationId}")
    public CommonResponse<?> editStation(@PathVariable("stationId") Long stationId, @Valid @RequestBody AddStationRequest request) {
        stationService.editStation(stationId, request.getName());
        return CommonResponse.success();
    }

    @DeleteMapping("admin/station/{stationId}")
    public CommonResponse<?> delStation(@PathVariable("stationId") Long stationId, @Valid @RequestBody AddStationRequest request) {
        stationService.delStation(stationId);
        return CommonResponse.success();
    }
}
