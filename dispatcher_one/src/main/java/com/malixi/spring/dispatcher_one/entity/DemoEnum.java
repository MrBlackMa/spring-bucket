package com.malixi.spring.dispatcher_one.entity;

/**
 * @Auther: smile malixi
 * @Date: 2021/3/30 - 23:15
 * @Description: com.malixi.spring.dispatcher_one.entity
 * @version: 1.0
 */
public enum DemoEnum {


    /**
     * 签到有礼活动不存在
     */
    ACTIVITY_IS_NULL(601001001, "签到有礼活动不存在！"),

    /**
     * 新增签到有礼活动失败
     */
    ADD_ACTIVITY_FAIL(601001002, "新增签到有礼活动失败！"),

    /**
     * 修改签到有礼活动失败
     */
    UPDATE_ACTIVITY_FAIL(601001003, "修改签到有礼活动失败！"),

    /**
     * 已存在的每日奖励规则禁止删除
     */
    FORBID_DELETE_REWARD_RULE(601001004, "已存在的奖励规则禁止删除！"),

    /**
     * 规则奖励值不能为空
     */
    RULE_REWARD_IS_NULL(601001005, "规则奖励值不能为空,规则类型:{},条件类型:{},条件值:{}"),

    /**
     * 签到规则不能为空
     */
    CHECKIN_RULE_IS_NULL(601001006, "签到规则不能为空！"),

    /**
     * 阶梯奖励规则配置不能为空
     */
    LADDER_REWARD_RULE_CONFIG_IS_NULL(601001006, "配置了阶梯奖励规则后,阶梯奖励规则配置不能为空！"),

    /**
     * 阶梯奖励规则配置禁止修改
     */
    FORBID_UPDATE_LADDER_RULE_CONFIG(601001007, "阶梯奖励规则配置禁止修改！"),

    /**
     * 阶梯奖励规则条件重复
     */
    REPEAT_LADDER_RULE_CONDITION(601001008, "阶梯奖励规则条件重复！"),

    /**
     * 阶梯奖励规则禁止删除
     */
    FORBID_DELETE_LADDER_RULE(601001009, "活动当前状态阶梯奖励规则禁止删除！"),

    /**
     * 修改奖励规则异常
     */
    UPDATE_LADDER_RULE_ERROR(601001010, "非法操作！阶梯奖励规则:{},不属于活动:{}"),

    /*
     * 签到活动已过期
     */
    ACTIVITY_IS_EXPIRED(601001011, "签到活动已过期！"),

    /**
     * 用户今日已签到
     */
    MEMBER_ALREADY_CHECKIN(601001012, "今日已签到！"),

    /**
     * 签到活动是停用状态
     */
    ACTIVITY_IS_DISABLED(601001013, "签到活动已经停用！"),

    /**
     * 签到数据保存数据库失败
     */
    ADD_CHECKIN_RECORD_FAIL(601001014, "签到失败！"),

    /**
     * 签到奖励记录保存失败
     */
    SAVE_CHECKIN_REWARD_DETAIL_FAIL(601001015, "签到奖励记录保存失败"),

    /**
     * 活动时间冲突
     */
    ACTIVITY_TIME_CONFLICT(601001016, "当期时间段内,{}门店已有生效的签到有礼活动,开启失败"),

    /**
     * 分站权限不足
     */
    SUBSITE_PERMISSION_DENIED(601001017, "分站权限不足,禁止操作!"),

    /**
     * 不允许多种阶梯奖励组合
     */
    MULTIPLE_LADDER_RULE_CONDITION(601001018, "不允许同时配置多种类型的阶梯奖励!"),

    /**
     * 下一个阶梯奖励的conditionValue小于上一个
     */
    NEXT_REWARD_LESS_THAN_LAST(601001019,"下一个阶梯奖励天数必须大于上一个"),

    /**
     * 阶梯奖励规则数量超过上限(7)
     */
    RULE_LIMIT_QUANTITY(601001020, "阶梯奖励规则数量超过上限!"),

    /**
     * 活动状态异常
     */
    ACTIVITY_STATUS_EXCEPTION(601001021, "当前活动状态异常：{}"),

    /**
     * 阶梯奖励规则和阶梯奖励规则配置必须同时添加
     */
    RULES_NOT_FOUND(601001022, "阶梯奖励规则和阶梯奖励规则配置必须同时添加,阶梯奖励规则列表为空"),

    /**
     * 阶梯奖励规则禁止删除
     */
    FORBID_ADD_LADDER_RULE(601001023, "活动当前状态阶梯奖励规则禁止添加！"),

    /**
     * 阶梯奖励规则和阶梯奖励规则配置必须同时添加
     */
    CONFIG_NOT_FOUND(601001024, "阶梯奖励规则和阶梯奖励规则配置必须同时添加,规则配置为null"),

    /**
     * 阶梯奖励规则禁止删除
     */
    FORBID_UPDATE_LADDER_RULE(601001025, "活动当前状态阶梯奖励规则禁止修改！");

    /**
     * 错误码
     */
    private final Integer errCode;

    /**
     * 错误信息
     */
    private final String errMsg;

    DemoEnum(int i, String s) {
        this.errCode=i;
        this.errMsg=s;
    }
}
