package com.flagleader.manager.a.a;

import com.flagleader.engine.RuleService;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.e.d;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.RuleGroup;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleRepository;
import com.flagleader.util.DateUtil;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import org.apache.commons.lang.SystemUtils;

public class a extends i
{
  public a(r paramr)
  {
    super(paramr);
  }

  public boolean a(int paramInt, String paramString, RulePackage paramRulePackage, boolean paramBoolean1, boolean paramBoolean2)
  {
    RuleService localRuleService = j();
    String str1 = this.b.b().getUserServer();
    int i = this.b.b().getUserType();
    int j = this.b.b().getUserid();
    if ((str1 == null) || (j == 0) || (i < 1))
      return false;
    localRuleService.put("loginname", str1);
    localRuleService.put("userid", j);
    localRuleService.put("rulename", paramRulePackage.getExeRulePackageName());
    localRuleService.put("modifytime", new Date(paramRulePackage.getMaxModifyTime()));
    if (paramInt > 0)
      localRuleService.put("ruleid", paramInt);
    if ((paramString != null) && (paramString.length() > 0))
      localRuleService.put("rulever", paramString);
    localRuleService.put("ruleproject", paramRulePackage.getProject().getDisplayName());
    localRuleService.put("lockcheckout", paramBoolean1);
    localRuleService.execute(this.a + "testcheckout");
    String str2 = localRuleService.getString("error");
    paramInt = localRuleService.getInteger("ruleid");
    int k = localRuleService.getInteger("errortype");
    int m = localRuleService.getInteger("ruletypeid");
    paramString = localRuleService.getString("rulever");
    if ((k == 0) || (paramBoolean2) || ((k == 1) && (this.b.b().showQuestion(paramRulePackage.getDisplayName() + str2))))
    {
      if (k == 1)
        paramBoolean2 = true;
      localRuleService = j();
      localRuleService.put("loginname", str1);
      localRuleService.put("userid", j);
      localRuleService.put("rulename", paramRulePackage.getExeRulePackageName());
      localRuleService.put("rulever", paramString);
      localRuleService.put("ruleid", paramInt);
      localRuleService.put("ruletypeid", m);
      localRuleService.put("ruleproject", paramRulePackage.getProject().getDisplayName());
      localRuleService.put("lockcheckout", paramBoolean1);
      localRuleService.execute(this.a + "loadRules");
      String str3 = localRuleService.getString("rulecontent");
      int n = localRuleService.getInteger("ruleright");
      str2 = localRuleService.getString("error");
      Date localDate = (Date)localRuleService.get("mtime");
      paramString = localRuleService.getString("rulever");
      if ((str2 == null) || (str2.length() == 0))
      {
        if ((localDate == null) || (paramRulePackage.getMaxModifyTime() / 1000L != localDate.getTime() / 1000L))
        {
          RulePackage localRulePackage = (RulePackage)new d().load(str3);
          paramRulePackage.replaceRulePackage(localRulePackage);
          this.b.j().c(paramRulePackage.toString() + " : " + c.a("successchange.checkout", "success check out!"));
          if (new File(SystemUtils.JAVA_IO_TMPDIR, paramRulePackage.getUuid()).exists())
            FileUtil.deleteAllFilesThenDirectories(new File(SystemUtils.JAVA_IO_TMPDIR, paramRulePackage.getUuid()), false);
        }
        else
        {
          this.b.j().d(paramRulePackage.getDisplayName() + c.b("success.checkout"));
        }
        if ((!paramRulePackage.getVersion().equals(paramString)) || (paramRulePackage.getRulesid() != localRuleService.getInteger("ruleid")))
        {
          paramRulePackage.setVersion(paramString);
          paramRulePackage.setRulesid(localRuleService.getInteger("ruleid"));
          paramRulePackage.setProjver(localRuleService.getString("projver"));
          paramRulePackage.setRuletypeid(m);
          paramRulePackage.setServerTime(localDate.getTime());
          paramRulePackage.setModified(true);
        }
        if (n == 1)
          paramRulePackage.setLocked(true);
        else
          paramRulePackage.setLocked(false);
        if (paramBoolean1)
          paramRulePackage.setCheckType(3);
        else
          paramRulePackage.setCheckType(2);
        paramRulePackage.setModifyTime(localDate.getTime());
        try
        {
          paramRulePackage.setNeedSave();
        }
        catch (Exception localException)
        {
        }
        if (paramRulePackage.getProject() != null)
          paramRulePackage.getProject().setNeedSave(true);
        paramRulePackage.disposeAllViewer();
        paramRulePackage.updateTree();
        return paramBoolean2;
      }
      this.b.b().showError(str2);
    }
    else
    {
      this.b.b().showError(paramRulePackage.getDisplayName() + str2);
    }
    return false;
  }

  public boolean a(RulePackage paramRulePackage)
  {
    RuleService localRuleService = j();
    String str1 = this.b.b().getUserServer();
    int i = this.b.b().getUserType();
    int j = this.b.b().getUserid();
    if ((str1 == null) || (j == 0) || (i < 1))
      return false;
    localRuleService.put("loginname", str1);
    localRuleService.put("userid", j);
    localRuleService.put("rulename", paramRulePackage.getExeRulePackageName());
    localRuleService.put("modifytime", new Date(paramRulePackage.getMaxModifyTime()));
    localRuleService.put("ruleproject", paramRulePackage.getProject().getDisplayName());
    localRuleService.execute(this.a + "testcheckout");
    String str2 = localRuleService.getString("error");
    int k = localRuleService.getInteger("ruleid");
    int m = localRuleService.getInteger("errortype");
    int n = localRuleService.getInteger("ruletypeid");
    String str3 = localRuleService.getString("rulever");
    Date localDate1 = localRuleService.getDate("modifytime");
    if (DateUtil.equalsDatetime(localDate1, new Date(paramRulePackage.getMaxModifyTime()), 0))
    {
      this.b.j().d(paramRulePackage.getDisplayName() + c.b("success.checkout"));
      return false;
    }
    if (DateUtil.moreEqualsThanDatetime(localDate1, new Date(paramRulePackage.getMaxModifyTime()), 0))
    {
      localRuleService = j();
      localRuleService.put("loginname", str1);
      localRuleService.put("userid", j);
      localRuleService.put("rulename", paramRulePackage.getExeRulePackageName());
      localRuleService.put("rulever", str3);
      localRuleService.put("ruleid", k);
      localRuleService.put("ruletypeid", n);
      localRuleService.put("ruleproject", paramRulePackage.getProject().getDisplayName());
      localRuleService.execute(this.a + "loadRules");
      String str4 = localRuleService.getString("rulecontent");
      int i1 = localRuleService.getInteger("ruleright");
      str2 = localRuleService.getString("error");
      Date localDate2 = (Date)localRuleService.get("mtime");
      str3 = localRuleService.getString("rulever");
      if ((str2 == null) || (str2.length() == 0))
      {
        if ((localDate2 == null) || (paramRulePackage.getMaxModifyTime() / 1000L != localDate2.getTime() / 1000L))
        {
          RulePackage localRulePackage = (RulePackage)new d().load(str4);
          paramRulePackage.replaceRulePackage(localRulePackage);
          this.b.j().c(paramRulePackage.getDisplayName() + c.a("successchange.checkout", "success check out!"));
          if (new File(SystemUtils.JAVA_IO_TMPDIR, paramRulePackage.getUuid()).exists())
            FileUtil.deleteAllFilesThenDirectories(new File(SystemUtils.JAVA_IO_TMPDIR, paramRulePackage.getUuid()), false);
        }
        else
        {
          this.b.j().d(paramRulePackage.toString() + " : " + c.b("success.checkout"));
        }
        if ((!paramRulePackage.getVersion().equals(str3)) || (paramRulePackage.getRulesid() != localRuleService.getInteger("ruleid")))
        {
          paramRulePackage.setVersion(str3);
          paramRulePackage.setRulesid(localRuleService.getInteger("ruleid"));
          paramRulePackage.setProjver(localRuleService.getString("projver"));
          paramRulePackage.setServerTime(localDate2.getTime());
          paramRulePackage.setRuletypeid(n);
          paramRulePackage.setModified(true);
        }
        if (i1 == 1)
          paramRulePackage.setLocked(true);
        else
          paramRulePackage.setLocked(false);
        paramRulePackage.setCheckType(2);
        paramRulePackage.setModifyTime(localDate2.getTime());
        try
        {
          paramRulePackage.setNeedSave();
        }
        catch (Exception localException)
        {
        }
        if (paramRulePackage.getProject() != null)
          paramRulePackage.getProject().setNeedSave(true);
        paramRulePackage.disposeAllViewer();
        paramRulePackage.updateTree();
        return true;
      }
      this.b.b().showError(str2);
    }
    else
    {
      a(paramRulePackage, false, 0, "", true);
    }
    return false;
  }

  private String c(RulePackage paramRulePackage)
  {
    if ((paramRulePackage.getParent() instanceof RuleGroup))
      return a((RuleGroup)paramRulePackage.getParent());
    return "";
  }

  private String a(RuleGroup paramRuleGroup)
  {
    if ((paramRuleGroup.getParent() instanceof RuleGroup))
      return a((RuleGroup)paramRuleGroup.getParent()) + "," + paramRuleGroup.getDisplayName();
    return paramRuleGroup.getDisplayName();
  }

  public boolean a(RulePackage paramRulePackage, boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    RuleService localRuleService = j();
    String str1 = this.b.b().getUserServer();
    int i = this.b.b().getUserType();
    int j = this.b.b().getUserid();
    if ((str1 == null) || (j == 0) || (i < 2))
      return paramBoolean2;
    try
    {
      long l = paramRulePackage.getMaxModifyTime();
      localRuleService.put("loginname", str1);
      localRuleService.put("userid", j);
      localRuleService.put("modifytime", new Date(l));
      localRuleService.put("rulename", paramRulePackage.getExeRulePackageName());
      localRuleService.put("ruleid", paramRulePackage.getRulesid());
      localRuleService.put("rulever", paramRulePackage.getVersion());
      localRuleService.put("mainversion", paramRulePackage.getMainVersion());
      localRuleService.put("projver", paramRulePackage.getProjver());
      localRuleService.put("projverid", paramInt);
      localRuleService.put("newversion", paramBoolean1);
      if (!StringUtil.isEmpty(paramString))
        localRuleService.put("ruleproject", paramString);
      localRuleService.put("lockcheckout", paramRulePackage.isLockCheckOut());
      localRuleService.put("mhint", paramRulePackage.getDocument());
      localRuleService.execute(this.a + "testcheckin");
      String str2 = localRuleService.getString("error");
      int k = localRuleService.getInteger("ruleid");
      int m = localRuleService.getInteger("errortype");
      String str3 = localRuleService.getString("rulever");
      String str4 = localRuleService.getString("projver");
      int n = localRuleService.getInteger("editstate");
      Date localDate = (Date)localRuleService.get("tt");
      int i1 = 2;
      if (this.b.v())
        i1 = 5;
      else if (!this.b.w())
        this.b.b().showError(c.b("norighterror.checkin"));
      paramBoolean1 = localRuleService.getBoolean("newversion");
      if ((m == 0) || (paramBoolean2) || ((m == 1) && (this.b.b().showQuestion(paramRulePackage.getDisplayName() + ":\n" + str2))))
        try
        {
          if (m == 1)
            paramBoolean2 = true;
          if ((str3 != null) && (!str3.equalsIgnoreCase(paramRulePackage.getVersion())))
            paramRulePackage.setVersion(str3);
          localRuleService = j();
          localRuleService.put("loginname", str1);
          localRuleService.put("userid", j);
          localRuleService.put("modifytime", new Date(l));
          localRuleService.put("ruleid", k);
          localRuleService.put("rulename", paramRulePackage.getExeRulePackageName());
          localRuleService.put("rulever", str3);
          localRuleService.put("projverid", paramInt);
          localRuleService.put("mainversion", paramRulePackage.getMainVersion());
          localRuleService.put("projver", paramRulePackage.getProjver());
          localRuleService.put("newversion", paramBoolean1);
          localRuleService.put("tt", localDate);
          localRuleService.put("ruletypeid", i1);
          localRuleService.put("ruledisplay", paramRulePackage.getDisplayName());
          localRuleService.put("editstate", n);
          localRuleService.put("lockcheckout", paramRulePackage.isLockCheckOut());
          String str5 = "";
          Iterator localIterator1 = paramRulePackage.getExportModels();
          while (localIterator1.hasNext())
            str5 = str5 + ((IPage)localIterator1.next()).getDisplayName() + "\n";
          localRuleService.put("jspinfo", str5);
          String str6 = "";
          Iterator localIterator2 = paramRulePackage.getEnvionment().getDBModels();
          while (localIterator2.hasNext())
          {
            DBModel localDBModel = (DBModel)localIterator2.next();
            Iterator localIterator3 = localDBModel.getAcceptChildren(new b(this));
            while (localIterator3.hasNext())
            {
              Object localObject = localIterator3.next();
              if ((localObject instanceof CustomSql))
              {
                str6 = str6 + ((CustomSql)localObject).getSqlCustom().replace('\n', ' ').replace('\r', ' ') + "\n";
              }
              else
              {
                if (!(localObject instanceof ISelectObject))
                  continue;
                str6 = str6 + ((ISelectObject)localObject).getSqlInfo() + "\n";
              }
            }
          }
          localRuleService.put("dbinfo", str6);
          localRuleService.put("groupinfo", c(paramRulePackage));
          localRuleService.put("mhint", paramRulePackage.getDocument());
          localRuleService.put("cancreate", true);
          localRuleService.put("forcesave", true);
          localRuleService.put("ipaddress", RuleRepository.getLocalip());
          localRuleService.put("changeproject", false);
          localRuleService.put("rulecontent", paramRulePackage.getSavedText());
          localRuleService.put("editlevel", paramRulePackage.getRuleEditLevel());
          if (!StringUtil.isEmpty(paramString))
            localRuleService.put("ruleproject", paramString);
          localRuleService.execute(this.a + "checkin");
          str2 = localRuleService.getString("error");
          str3 = localRuleService.getString("rulever");
          if ((str2 == null) || (str2.length() == 0))
          {
            paramRulePackage.setRulesid(localRuleService.getInteger("ruleid"));
            paramRulePackage.setVersion(str3);
            paramRulePackage.setProjver(str4);
            paramRulePackage.setServerTime(l);
            paramRulePackage.setCheckType(1);
            if (paramRulePackage.getProject() != null)
              paramRulePackage.getProject().setNeedSave(true);
            try
            {
              paramRulePackage.selfSave();
              paramRulePackage.setModified(false);
            }
            catch (Exception localException2)
            {
              this.b.b().showError(c.a("saveerror.checkin", new String[] { localException2.getMessage() }));
            }
            paramRulePackage.disposeAllViewer();
            paramRulePackage.updateTree();
            this.b.j().c(paramRulePackage.getDisplayName() + c.b("success.updatedb"));
            break label1417;
          }
          this.b.j().a(paramRulePackage.getDisplayName() + str2);
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          this.b.b().showError(c.a("error.checkin", new String[] { localException1.getMessage() }));
        }
      else if (m == 2)
        this.b.b().showError(paramRulePackage.getDisplayName() + str2);
    }
    catch (Throwable localThrowable)
    {
      this.b.b().showError(c.a("error.checkin", new String[] { localThrowable.getMessage() }));
    }
    label1417: return paramBoolean2;
  }

  public void b(RulePackage paramRulePackage)
  {
    RuleService localRuleService = j();
    String str1 = this.b.b().getUserServer();
    int i = this.b.b().getUserType();
    int j = this.b.b().getUserid();
    if ((str1 == null) || (j == 0) || (i < 2))
      return;
    try
    {
      long l = paramRulePackage.getMaxModifyTime();
      localRuleService.put("loginname", str1);
      localRuleService.put("userid", j);
      localRuleService.put("modifytime", new Date(l));
      localRuleService.put("rulename", paramRulePackage.getExeRulePackageName());
      localRuleService.put("ruleid", paramRulePackage.getRulesid());
      localRuleService.put("rulever", paramRulePackage.getVersion());
      localRuleService.put("mainversion", paramRulePackage.getMainVersion());
      localRuleService.put("projver", paramRulePackage.getProjver());
      localRuleService.put("lockcheckout", paramRulePackage.isLockCheckOut());
      localRuleService.put("mhint", paramRulePackage.getDocument());
      localRuleService.execute(this.a + "unlockcheckout");
      String str2 = localRuleService.getString("error");
      int k = localRuleService.getInteger("errortype");
      if ((k != 0) && (this.b.b().showQuestion(paramRulePackage.getDisplayName() + ":\n" + str2)))
        this.b.b().showError(paramRulePackage.getDisplayName() + ":\n" + str2);
      else if (localRuleService.getInteger("successtype") == 1)
        this.b.j().c(paramRulePackage.getDisplayName() + c.b("unlockcheckoutsuccess.CheckOutService"));
    }
    catch (Throwable localThrowable)
    {
      this.b.b().showError(c.a("error.checkin", new String[] { localThrowable.getMessage() }));
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.a.a
 * JD-Core Version:    0.6.0
 */