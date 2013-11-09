package com.flagleader.manager.c;

import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.repository.IElement;
import com.flagleader.repository.e.k;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.tree.AbstractRuleSet;
import com.flagleader.repository.tree.DecisionElement;
import com.flagleader.repository.tree.DecisionMultiRule;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.ExpressionRule;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleSet;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class g extends k
{
  public g()
  {
  }

  public g(PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    super(paramPrintWriter, paramBoolean);
  }

  public g(PrintWriter paramPrintWriter)
  {
    super(paramPrintWriter);
  }

  protected void a(String paramString1, String paramString2)
  {
    d();
    d("<td wrap class=c>" + paramString1 + "</td>");
    d("<td wrap class=f>" + paramString2 + "</td>");
    e();
  }

  private String a(boolean paramBoolean)
  {
    return paramBoolean ? "true" : "false";
  }

  protected void a(IElement paramIElement)
  {
    d("<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" class=tableBorder>" + q);
    Object localObject;
    if ((paramIElement instanceof RulePackage))
    {
      localObject = (RulePackage)paramIElement;
      a(c.b("lasttime.dialog"), ((RulePackage)localObject).getLastModifyTime());
      a(c.b("modifyuser.dialog"), ((RulePackage)localObject).getModifyUser());
      a(c.b("vmlFlowType.RulePackagePropertiesEditor"), com.flagleader.manager.c.d.y.l[localObject.getVmlFlowType()]);
      if (((RulePackage)localObject).isDeveloper())
      {
        a(c.b("version.dialog"), ((RulePackage)localObject).getVersion());
        a(c.b("projver.dialog"), ((RulePackage)localObject).getProjver());
        a(c.b("name.dialog"), ((RulePackage)localObject).getDisplayName());
        a(c.b("exepackagename.dialog"), ((RulePackage)localObject).getExeRulePackageName());
        a(c.b("mainversion.dialog"), ((RulePackage)localObject).getMainVersion());
        a(c.b("ruleid.dialog"), String.valueOf(((RulePackage)localObject).getRulesid()));
        a(c.b("lockType.dialog"), com.flagleader.manager.c.d.y.j[localObject.getLockType()]);
        a(c.b("ruleeditlevel.RulePackageProperties"), com.flagleader.manager.c.d.y.g[localObject.getRuleEditLevel()]);
        a(c.b("checkType.dialog"), com.flagleader.manager.c.d.y.i[localObject.getCheckType()]);
        a(c.b("packagedir.dialog"), ((RulePackage)localObject).getFilePathName());
        a(c.b("exepackagedir.dialog"), ((RulePackage)localObject).getExportDir());
        a(c.b("order.dialog"), String.valueOf(((RulePackage)localObject).getPos() + 1));
        a(c.b("stringignore.dialog"), com.flagleader.manager.c.d.y.a[localObject.getStringignore()]);
        a(c.b("stringinit.dialog"), com.flagleader.manager.c.d.y.e[localObject.getStringinit()]);
        a(c.b("datenull.dialog"), com.flagleader.manager.c.d.y.f[localObject.getDatenulltype()]);
        a(c.b("packlogtype.RulePackagePropertiesEditor"), com.flagleader.manager.c.d.y.n[localObject.getLogType()]);
        a(c.b("packlogdb.RulePackagePropertiesEditor"), com.flagleader.manager.c.d.y.n[localObject.getDblog()]);
        a(c.b("needlogtime.RuleTreeProperties"), com.flagleader.manager.c.d.y.k[localObject.getLogTimes()]);
      }
      else
      {
        a(c.b("version.dialog"), ((RulePackage)localObject).getVersion());
      }
    }
    else if ((paramIElement instanceof Rule))
    {
      localObject = (Rule)paramIElement;
      a(c.b("lasttime.dialog"), ((Rule)localObject).getLastModifyTime());
      a(c.b("modifyuser.dialog"), ((Rule)localObject).getModifyUser());
      a(c.b("active.dialog"), a(((Rule)localObject).isActived()));
      a(c.b("syn.dialog"), a(((Rule)localObject).isSyn()));
      a(c.b("vmlshow.dialog"), com.flagleader.manager.c.d.Z.a[localObject.getVml()]);
      a(c.b("name.dialog"), ((Rule)localObject).getDisplayName());
      a(c.b("edittable.dialog"), a(((Rule)localObject).isEditTable()));
      a(c.b("condition.dialog"), a(((Rule)localObject).isSupportEnter()));
      a(c.b("supportInit.dialog"), a(((Rule)localObject).isSupportInit()));
      a(c.b("supportElse.dialog"), a(((Rule)localObject).isSupportElse()));
      a(c.b("supportException.dialog"), a(((Rule)localObject).isSupportCatch()));
      a(c.b("sheetwhile.dialog"), a(((Rule)localObject).isSheetWhile()));
      if ((((Rule)localObject).isSheetWhile()) && (((Rule)localObject).getWhileSheet() != null))
        a(c.b("sheetuuid.dialog"), ((Rule)localObject).getWhileSheet().getShowDisplayName());
      a(c.b("pri.dialog"), String.valueOf(((Rule)localObject).getPos() + 1));
      a(c.b("ruleType.dialog"), com.flagleader.manager.c.d.Z.e[localObject.getExceptionType()]);
      if ((((Rule)localObject).getExceptionType() == 1) || (((Rule)localObject).getExceptionType() == 2))
        a(c.b("errorInfo.dialog"), ((Rule)localObject).getErrorMsg());
      a(c.b("sheetothers.dialog"), com.flagleader.manager.c.d.Z.h[localObject.getSheetOther()]);
      a(c.b("logtypes.dialog"), com.flagleader.manager.c.d.Z.k[localObject.getLogtype()]);
      a(c.b("datasnaps.dialog"), com.flagleader.manager.c.d.Z.i[localObject.getDataShap()]);
      a(c.b("restartType.RuleTreeProperties"), com.flagleader.manager.c.d.Z.l[localObject.getRestartType()]);
      a(c.b("vmlFlowType.RuleTreeProperties"), com.flagleader.manager.c.d.Z.o[localObject.getVmlFlowType()]);
      if (((Rule)localObject).getStartTime() > 0L)
        a(c.b("startTime.dialog"), new SimpleDateFormat(b.a().h()).format(new Date(((Rule)localObject).getStartTime())));
      if (((Rule)localObject).getEndTime() > 0L)
        a(c.b("startTime.dialog"), new SimpleDateFormat(b.a().h()).format(new Date(((Rule)localObject).getEndTime())));
    }
    else if ((paramIElement instanceof DecisionRule))
    {
      localObject = (DecisionRule)paramIElement;
      a(c.b("lasttime.dialog"), ((DecisionRule)localObject).getLastModifyTime());
      a(c.b("modifyuser.dialog"), ((DecisionRule)localObject).getModifyUser());
      a(c.b("active.dialog"), a(((DecisionRule)localObject).isActived()));
      a(c.b("syn.dialog"), a(((DecisionRule)localObject).isSyn()));
      a(c.b("vmlshow.dialog"), com.flagleader.manager.c.d.Z.a[localObject.getVml()]);
      a(c.b("name.dialog"), ((DecisionRule)localObject).getDisplayName());
      a(c.b("sheetwhile.dialog"), a(((DecisionRule)localObject).isSheetWhile()));
      if ((((DecisionRule)localObject).isSheetWhile()) && (((DecisionRule)localObject).getWhileSheet() != null))
        a(c.b("sheetuuid.dialog"), ((DecisionRule)localObject).getWhileSheet().getShowDisplayName());
      a(c.b("pri.dialog"), String.valueOf(((DecisionRule)localObject).getPos() + 1));
      a(c.b("conditionNum.dialog"), String.valueOf(((DecisionRule)localObject).getConditionNum()));
      if (((DecisionRule)localObject).getMemberElement() != null)
        a(c.b("assignDecision.dialog"), ((DecisionRule)localObject).getMemberElement().getShowDisplayName());
      a(c.b("sheetothers.dialog"), com.flagleader.manager.c.d.ao.h[localObject.getSheetOther()]);
      a(c.b("logtypes.dialog"), com.flagleader.manager.c.d.Z.k[localObject.getLogtype()]);
      a(c.b("datasnaps.dialog"), com.flagleader.manager.c.d.Z.i[localObject.getDataShap()]);
      a(c.b("restartType.RuleTreeProperties"), com.flagleader.manager.c.d.Z.l[localObject.getRestartType()]);
      a(c.b("matchType.RuleTreeProperties"), com.flagleader.manager.c.d.ao.m[localObject.getMatchType()]);
      a(c.b("vmlFlowType.RuleTreeProperties"), com.flagleader.manager.c.d.Z.o[localObject.getVmlFlowType()]);
      if (((DecisionRule)localObject).getStartTime() > 0L)
        a(c.b("startTime.dialog"), new SimpleDateFormat(b.a().h()).format(new Date(((DecisionRule)localObject).getStartTime())));
      if (((DecisionRule)localObject).getEndTime() > 0L)
        a(c.b("startTime.dialog"), new SimpleDateFormat(b.a().h()).format(new Date(((DecisionRule)localObject).getEndTime())));
    }
    else
    {
      int i;
      if ((paramIElement instanceof DecisionRelateRule))
      {
        localObject = (DecisionRelateRule)paramIElement;
        a(c.b("lasttime.dialog"), ((DecisionRelateRule)localObject).getLastModifyTime());
        a(c.b("modifyuser.dialog"), ((DecisionRelateRule)localObject).getModifyUser());
        a(c.b("active.dialog"), a(((DecisionRelateRule)localObject).isActived()));
        a(c.b("syn.dialog"), a(((DecisionRelateRule)localObject).isSyn()));
        a(c.b("vmlshow.dialog"), com.flagleader.manager.c.d.Z.a[localObject.getVml()]);
        a(c.b("name.dialog"), ((DecisionRelateRule)localObject).getDisplayName());
        a(c.b("sheetwhile.dialog"), a(((DecisionRelateRule)localObject).isSheetWhile()));
        if ((((DecisionRelateRule)localObject).isSheetWhile()) && (((DecisionRelateRule)localObject).getWhileSheet() != null))
          a(c.b("sheetuuid.dialog"), ((DecisionRelateRule)localObject).getWhileSheet().getShowDisplayName());
        a(c.b("pri.dialog"), String.valueOf(((DecisionRelateRule)localObject).getPos() + 1));
        a(c.b("conditionNum.dialog"), String.valueOf(((DecisionRelateRule)localObject).getConditionNum()));
        a(c.b("valueNum.dialog"), String.valueOf(((DecisionRelateRule)localObject).getValueNum()));
        for (i = 1; i <= ((DecisionRelateRule)localObject).getValueNum(); i++)
        {
          if ((((DecisionRelateRule)localObject).getDecisionElement(i) == null) || (((DecisionRelateRule)localObject).getDecisionElement(i).getMemberElement() == null))
            continue;
          a(c.b("assignDecision.dialog"), ((DecisionRelateRule)localObject).getDecisionElement(i).getMemberElement().getShowDisplayName());
        }
        a(c.b("sheetothers.dialog"), com.flagleader.manager.c.d.ao.h[localObject.getSheetOther()]);
        a(c.b("logtypes.dialog"), com.flagleader.manager.c.d.Z.k[localObject.getLogtype()]);
        a(c.b("datasnaps.dialog"), com.flagleader.manager.c.d.Z.i[localObject.getDataShap()]);
        a(c.b("restartType.RuleTreeProperties"), com.flagleader.manager.c.d.Z.l[localObject.getRestartType()]);
        a(c.b("matchType.RuleTreeProperties"), com.flagleader.manager.c.d.ao.m[localObject.getMatchType()]);
        a(c.b("vmlFlowType.RuleTreeProperties"), com.flagleader.manager.c.d.Z.o[localObject.getVmlFlowType()]);
        if (((DecisionRelateRule)localObject).getStartTime() > 0L)
          a(c.b("startTime.dialog"), new SimpleDateFormat(b.a().h()).format(new Date(((DecisionRelateRule)localObject).getStartTime())));
        if (((DecisionRelateRule)localObject).getEndTime() > 0L)
          a(c.b("startTime.dialog"), new SimpleDateFormat(b.a().h()).format(new Date(((DecisionRelateRule)localObject).getEndTime())));
      }
      else if ((paramIElement instanceof DecisionMultiRule))
      {
        localObject = (DecisionMultiRule)paramIElement;
        a(c.b("lasttime.dialog"), ((DecisionMultiRule)localObject).getLastModifyTime());
        a(c.b("modifyuser.dialog"), ((DecisionMultiRule)localObject).getModifyUser());
        a(c.b("active.dialog"), a(((DecisionMultiRule)localObject).isActived()));
        a(c.b("syn.dialog"), a(((DecisionMultiRule)localObject).isSyn()));
        a(c.b("vmlshow.dialog"), com.flagleader.manager.c.d.Z.a[localObject.getVml()]);
        a(c.b("name.dialog"), ((DecisionMultiRule)localObject).getDisplayName());
        a(c.b("sheetwhile.dialog"), a(((DecisionMultiRule)localObject).isSheetWhile()));
        if ((((DecisionMultiRule)localObject).isSheetWhile()) && (((DecisionMultiRule)localObject).getWhileSheet() != null))
          a(c.b("sheetuuid.dialog"), ((DecisionMultiRule)localObject).getWhileSheet().getShowDisplayName());
        a(c.b("pri.dialog"), String.valueOf(((DecisionMultiRule)localObject).getPos() + 1));
        a(c.b("conditionNum.dialog"), String.valueOf(((DecisionMultiRule)localObject).getConditionNum()));
        a(c.b("valueNum.dialog"), String.valueOf(((DecisionMultiRule)localObject).getValueNum()));
        for (i = 1; i <= ((DecisionMultiRule)localObject).getValueNum(); i++)
        {
          if ((((DecisionMultiRule)localObject).getDecisionElement(i) == null) || (((DecisionMultiRule)localObject).getDecisionElement(i).getMemberElement() == null))
            continue;
          a(c.b("assignDecision.dialog"), ((DecisionMultiRule)localObject).getDecisionElement(i).getMemberElement().getShowDisplayName());
        }
        a(c.b("sheetothers.dialog"), com.flagleader.manager.c.d.ao.h[localObject.getSheetOther()]);
        a(c.b("logtypes.dialog"), com.flagleader.manager.c.d.Z.k[localObject.getLogtype()]);
        a(c.b("datasnaps.dialog"), com.flagleader.manager.c.d.Z.i[localObject.getDataShap()]);
        a(c.b("restartType.RuleTreeProperties"), com.flagleader.manager.c.d.Z.l[localObject.getRestartType()]);
        a(c.b("matchType.RuleTreeProperties"), com.flagleader.manager.c.d.ao.m[localObject.getMatchType()]);
        a(c.b("vmlFlowType.RuleTreeProperties"), com.flagleader.manager.c.d.Z.o[localObject.getVmlFlowType()]);
        if (((DecisionMultiRule)localObject).getStartTime() > 0L)
          a(c.b("startTime.dialog"), new SimpleDateFormat(b.a().h()).format(new Date(((DecisionMultiRule)localObject).getStartTime())));
        if (((DecisionMultiRule)localObject).getEndTime() > 0L)
          a(c.b("startTime.dialog"), new SimpleDateFormat(b.a().h()).format(new Date(((DecisionMultiRule)localObject).getEndTime())));
      }
      else if ((paramIElement instanceof ExpressionRule))
      {
        localObject = (ExpressionRule)paramIElement;
        a(c.b("lasttime.dialog"), ((ExpressionRule)localObject).getLastModifyTime());
        a(c.b("modifyuser.dialog"), ((ExpressionRule)localObject).getModifyUser());
        a(c.b("active.dialog"), a(((ExpressionRule)localObject).isActived()));
        a(c.b("syn.dialog"), a(((ExpressionRule)localObject).isSyn()));
        a(c.b("vmlshow.dialog"), com.flagleader.manager.c.d.Z.a[localObject.getVml()]);
        a(c.b("name.dialog"), ((ExpressionRule)localObject).getDisplayName());
        a(c.b("sheetwhile.dialog"), a(((ExpressionRule)localObject).isSheetWhile()));
        if ((((ExpressionRule)localObject).isSheetWhile()) && (((ExpressionRule)localObject).getWhileSheet() != null))
          a(c.b("sheetuuid.dialog"), ((ExpressionRule)localObject).getWhileSheet().getShowDisplayName());
        a(c.b("pri.dialog"), String.valueOf(((ExpressionRule)localObject).getPos() + 1));
        a(c.b("sheetothers.dialog"), com.flagleader.manager.c.d.ao.h[localObject.getSheetOther()]);
        a(c.b("logtypes.dialog"), com.flagleader.manager.c.d.Z.k[localObject.getLogtype()]);
        a(c.b("datasnaps.dialog"), com.flagleader.manager.c.d.Z.i[localObject.getDataShap()]);
        a(c.b("restartType.RuleTreeProperties"), com.flagleader.manager.c.d.Z.l[localObject.getRestartType()]);
        a(c.b("matchType.RuleTreeProperties"), com.flagleader.manager.c.d.ao.m[localObject.getMatchType()]);
        a(c.b("vmlFlowType.RuleTreeProperties"), com.flagleader.manager.c.d.Z.o[localObject.getVmlFlowType()]);
        if (((ExpressionRule)localObject).getStartTime() > 0L)
          a(c.b("startTime.dialog"), new SimpleDateFormat(b.a().h()).format(new Date(((ExpressionRule)localObject).getStartTime())));
        if (((ExpressionRule)localObject).getEndTime() > 0L)
          a(c.b("startTime.dialog"), new SimpleDateFormat(b.a().h()).format(new Date(((ExpressionRule)localObject).getEndTime())));
      }
      else if ((paramIElement instanceof AbstractRuleSet))
      {
        localObject = (AbstractRuleSet)paramIElement;
        a(c.b("lasttime.dialog"), ((AbstractRuleSet)localObject).getLastModifyTime());
        a(c.b("modifyuser.dialog"), ((AbstractRuleSet)localObject).getModifyUser());
        a(c.b("active.dialog"), a(((AbstractRuleSet)localObject).isActived()));
        a(c.b("syn.dialog"), a(((AbstractRuleSet)localObject).isSyn()));
        a(c.b("vmlshow.dialog"), com.flagleader.manager.c.d.Z.a[localObject.getVml()]);
        a(c.b("name.dialog"), ((AbstractRuleSet)localObject).getDisplayName());
        if ((paramIElement instanceof RuleSet))
          a(c.b("edittable.dialog"), a(((RuleSet)localObject).isEditTable()));
        a(c.b("first.dialog"), a(((AbstractRuleSet)localObject).isFirst()));
        a(c.b("supportException.dialog"), a(((AbstractRuleSet)localObject).isSupportCatch()));
        a(c.b("sheetwhile.dialog"), a(((AbstractRuleSet)localObject).isSheetWhile()));
        if ((((AbstractRuleSet)localObject).isSheetWhile()) && (((AbstractRuleSet)localObject).getWhileSheet() != null))
          a(c.b("sheetuuid.dialog"), ((AbstractRuleSet)localObject).getWhileSheet().getShowDisplayName());
        a(c.b("pri.dialog"), String.valueOf(((AbstractRuleSet)localObject).getPos() + 1));
        a(c.b("ruleSetType.dialog"), com.flagleader.manager.c.d.ak.f[localObject.getEditType()]);
        a(c.b("sheetothers.dialog"), com.flagleader.manager.c.d.ao.h[localObject.getSheetOther()]);
        a(c.b("ruleType.dialog"), com.flagleader.manager.c.d.Z.e[localObject.getExceptionType()]);
        if ((((AbstractRuleSet)localObject).getExceptionType() == 1) || (((AbstractRuleSet)localObject).getExceptionType() == 2))
          a(c.b("errorInfo.dialog"), ((AbstractRuleSet)localObject).getErrorMsg());
        a(c.b("logtypes.dialog"), com.flagleader.manager.c.d.Z.g[localObject.getLogtype()]);
        a(c.b("datasnaps.dialog"), com.flagleader.manager.c.d.Z.i[localObject.getDataShap()]);
        a(c.b("restartType.RuleTreeProperties"), com.flagleader.manager.c.d.Z.l[localObject.getRestartType()]);
        a(c.b("vmlFlowType.RuleTreeProperties"), com.flagleader.manager.c.d.Z.o[localObject.getVmlFlowType()]);
        if (((AbstractRuleSet)localObject).getStartTime() > 0L)
          a(c.b("startTime.dialog"), new SimpleDateFormat(b.a().h()).format(new Date(((AbstractRuleSet)localObject).getStartTime())));
        if (((AbstractRuleSet)localObject).getEndTime() > 0L)
          a(c.b("startTime.dialog"), new SimpleDateFormat(b.a().h()).format(new Date(((AbstractRuleSet)localObject).getEndTime())));
      }
    }
    d("</table><p/>" + q);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.g
 * JD-Core Version:    0.6.0
 */