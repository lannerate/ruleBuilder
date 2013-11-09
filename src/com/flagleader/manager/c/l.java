package com.flagleader.manager.c;

import com.flagleader.manager.builder.b;
import com.flagleader.manager.c.c.f;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.ClassContainer;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.InterfaceContainer;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlNode;
import java.io.File;

public class l
  implements f
{
  public l(h paramh)
  {
  }

  public String a()
  {
    return this.a.d().getDisplayName();
  }

  public boolean a(String paramString)
  {
    if (!this.a.c.getDisplayName().equals(paramString))
    {
      if ((this.a.c instanceof RulePackage))
      {
        RulePackage localRulePackage = (RulePackage)this.a.c;
        if (localRulePackage.getProject() != null)
        {
          if (!localRulePackage.getProject().canChangePackName(localRulePackage))
          {
            this.a.d.b().showError(c.b("changePackNameError"));
            return false;
          }
          if (localRulePackage.getExeRulePackageName().equals(localRulePackage.getDisplayName()))
          {
            if ((localRulePackage.getProject() != null) && (localRulePackage.getProject().exitsPackage(paramString.toString()) != null))
            {
              this.a.d.b().showError(c.b("exitsPackage.RulePackagePropertiesEditor"));
              return false;
            }
            if (new File(localRulePackage.getFilePathName()).exists())
              this.a.d.b().showQuestion(c.b("deleteFile.RulePackagePropertiesEditor"), new j(this.a, localRulePackage));
            localRulePackage.setExeRulePackageName(paramString.toString());
          }
          localRulePackage.setDisplayName(paramString);
        }
        else
        {
          localRulePackage.setDisplayName(paramString);
        }
      }
      else if ((this.a.c instanceof IBOAndContainer))
      {
        ((IBOAndContainer)this.a.c).changeDisplayName(paramString);
        ((IBOAndContainer)this.a.c).updateViewer();
      }
      else if ((this.a.c instanceof CustomSql))
      {
        ((CustomSql)this.a.c).changeDisplayName(paramString);
        ((CustomSql)this.a.c).getDBModel().updateViewer();
      }
      else if ((this.a.c instanceof XmlNode))
      {
        ((XmlNode)this.a.c).changeDisplayName(paramString);
        ((XmlNode)this.a.c).updateFunction();
        ((XmlNode)this.a.c).updateViewer();
      }
      else if ((this.a.c instanceof TreeValueNode))
      {
        this.a.c.changeDisplayName(paramString);
        ((TreeValueNode)this.a.c).resetFunction();
        ((TreeValueNode)this.a.c).updateViewer();
      }
      else if ((this.a.c instanceof ClassContainer))
      {
        this.a.c.changeDisplayName(paramString);
        ((ClassContainer)this.a.c).resetFunction();
        ((ClassContainer)this.a.c).updateViewer();
      }
      else if ((this.a.c instanceof InterfaceContainer))
      {
        this.a.c.changeDisplayName(paramString);
        ((InterfaceContainer)this.a.c).resetFunction();
        ((InterfaceContainer)this.a.c).updateViewer();
      }
      else if ((this.a.c instanceof SoapService))
      {
        this.a.c.changeDisplayName(paramString);
        ((SoapService)this.a.c).updateFunction();
        ((SoapService)this.a.c).updateViewer();
      }
      else
      {
        this.a.c.changeDisplayName(paramString);
      }
      this.a.c.setModified(true);
      this.a.c.updateText();
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.l
 * JD-Core Version:    0.6.0
 */