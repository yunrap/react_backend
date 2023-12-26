/**
 * jQuery 사용자 정의 함수
 */
$.fn.extend({
    /**
     * FORM 내부의 값을 Object로 변환
     *
     * @param disableInclude Object return 여부
     * @return objReturn
     */
    getFormObject: function(disableInclude) {
        var objReturn = {},
            arrInput = this.serializeArray(),
            arrDisabled = $(this).find(":disabled"),
            arrCheck = $(this).find("input[type='checkbox']:not(.multiSelect)"),
            arrRadio = $(this).find("input[type='radio']:not(.multiSelect):checked"),
            arrMulti = $(this).find("select"), arrSelectVal = null;

        var disableFlag = false;
        if(disableInclude != null && disableInclude) {
            disableFlag = true;
        }
        $.each(arrInput, function() {
            if( $("input[name='"+this.name+"']").data('daterangepicker') != null ) {
                var dateCom = $("input[name='"+this.name+"']").data('daterangepicker');
                var format = "YYYYMMDD";
                if(dateCom.timePicker && dateCom.timePicker24Hour ) {
                    format +="HHmmss";
                }

                if(dateCom.singleDatePicker) {
                    objReturn[this.name] = dateCom.startDate.format(format);
                } else {
                    objReturn[this.name+"_START"] = dateCom.startDate.format(format);
                    objReturn[this.name+"_END"] = dateCom.endDate.format(format);
                }
            } else {
                objReturn[this.name] = this.value || null;
            }
        });
        $.each(arrCheck, function() {
            objReturn[this.name] = this.checked?'Y':'N';
        });
        $.each(arrRadio, function() {
            objReturn[this.name] = this.value;
        });
        $.each(arrMulti, function() {
            delete objReturn['selectAll'+this.name];
            delete objReturn['selectItem'+this.name];

            if(this.style.display !== "none") {
                objReturn[this.name] = this.value;
            } else {
                objReturn[this.name] = "";
                arrSelectVal = $(this).multipleSelect("getSelects").value;
                if(arrSelectVal.constructor == Array) {
                    if(this.multiple == true) {  // multiple
                        if($(this).val() == null && arrSelectVal.length > 0) {
                            objReturn[this.name] = null;
                        }
//						if(!arrSelectVal || arrSelectVal.length == 0) objReturn[this.name] = null;
                        else {
                            for(var selIdx =0; selIdx< arrSelectVal.length; selIdx++) {
                                if(arrSelectVal[selIdx] == "noValue") {
                                    var valueFi = comm.getDataset(this,"no-value-field");
                                    if( valueFi != null && valueFi != "" ) {
                                        objReturn[valueFi] = "Y";
                                    }
                                }
                            }

                            objReturn[this.name] = arrSelectVal;
                        }
                    } else if(arrSelectVal.length == 1) {  // single
                        objReturn[this.name] = arrSelectVal[0];
                    }
                }
            }
        });

        if( !disableFlag ) {
            $.each(arrDisabled, function() {
                delete objReturn[this.name];
            });
        }else{
            $.each(arrDisabled, function() {
                objReturn[this.name] = this.value || null;
            });
        }

        return objReturn;
    },


});



/**
 * 공통 자바스크립트 함수
 *
 */
var comm = {
    /**
     * POST 방식 AJAX
     *
     * @param objParam
     */
    ajaxPost: function( objParam ) {
        $.ajax({
            contentType: "application/json; charset=utf-8",
            type: "POST",
            dataType: "json",
            data: JSON.stringify(objParam.data),
            url : objParam.url,
            success:  function() { alert("성공하였습니다."); },
            error: function() { alert("실패하였습니다."); },
            complete: function() {
                console.log("성공");
            }
        });
    },

    /**
     * 달력 공통함수 (daterangepiker) TODO 외부 공공데이터 공휴일추가필요
     *
     * @param id 값, startDay(시작일), endDay(종료일)
     * @return objReturn
     */
    datepicker : function(id, startDay, endDay) {
        jQuery("#" + id).attr("readonly", true);
        jQuery("#" + id).daterangepicker({
            locale: {
                separator: " ~ ",                     // 시작일시와 종료일시 구분자
                format: 'YYYY-MM-DD',                 // 일시 노출 포맷
                applyLabel: "확인",                    // 확인 버튼 텍스트
                cancelLabel: "취소",                   // 취소 버튼 텍스트
                daysOfWeek: ["일", "월", "화", "수", "목", "금", "토"],
                monthNames: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"]
            },
            timePicker: false,                        // 시간 노출 여부
            showDropdowns: true,                     // 년월 수동 설정 여부
            autoApply: true,                         // 확인/취소 버튼 사용여부
            timePicker24Hour: true,                  // 24시간 노출 여부(ex> true : 23:50, false : PM 11:50)
            timePickerSeconds: true,                 // 초 노출 여부
            singleDatePicker: false                   // 하나의 달력 사용 여부
        }, function (start, end, label) {

            console.log(start, end, label);
            console.log(startDay, endDay);
            console.log("안탄다")

            var date = $("#" + id).data('daterangepicker');
            if(startDay != null){
                date.setStartDate(startDay);
            }

            if(endDay != null){
                date.setEndDate(endDay);
            }
        })
    },

}

