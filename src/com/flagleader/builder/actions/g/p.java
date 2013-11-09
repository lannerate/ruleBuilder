package com.flagleader.builder.actions.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.d.b;
import com.flagleader.manager.r;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.TestCaseLib;
import java.io.File;
import java.util.Iterator;
import org.eclipse.swt.widgets.DirectoryDialog;

public class p extends bl
{
  public p(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "ImportTestCaseLib";
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode instanceof IRuleGroup))
    {
      IRuleGroup localIRuleGroup = (IRuleGroup)paramITreeNode;
      DirectoryDialog localDirectoryDialog = new DirectoryDialog(this.a.getShell());
      Object localObject1;
      if (localIRuleGroup.getProject() != null)
      {
        localObject1 = new File(new File(localIRuleGroup.getProject().getFilePath()).getParent(), "test");
        if (!((File)localObject1).exists())
          ((File)localObject1).mkdirs();
        localDirectoryDialog.setFilterPath(((File)localObject1).getAbsolutePath());
      }
      else if (this.a.getConfigManager().f().length() > 0)
      {
        if (new File(this.a.getConfigManager().f()).exists())
          localDirectoryDialog.setFilterPath(new File(this.a.getConfigManager().f()).getAbsolutePath());
        else
          localDirectoryDialog.setFilterPath(this.a.getConfigManager().a + File.separator + this.a.getConfigManager().f());
      }
      if ((localDirectoryDialog.open() != null) && (localDirectoryDialog.getFilterPath().length() > 0))
      {
        localObject1 = localDirectoryDialog.getFilterPath();
        Iterator localIterator1 = ((IRuleGroup)paramITreeNode).getAcceptElements(new q(this));
        while (localIterator1.hasNext())
        {
          IRulePackage localIRulePackage = (IRulePackage)localIterator1.next();
          String str = localIRulePackage.getDisplayName() + TestCaseLib.DISPLAYNAME + ".xls";
          File localFile = new File((String)localObject1, str);
          if (!localFile.exists())
            continue;
          TestCaseLib localTestCaseLib = null;
          Iterator localIterator2 = localIRulePackage.getChildrenIterator();
          while (localIterator2.hasNext())
          {
            Object localObject2 = localIterator2.next();
            if ((!(localObject2 instanceof TestCaseLib)) || (!((TestCaseLib)localObject2).getDisplayName().equals(TestCaseLib.DISPLAYNAME)))
              continue;
            localTestCaseLib = (TestCaseLib)localObject2;
            break;
          }
          if (localTestCaseLib == null)
            localTestCaseLib = (TestCaseLib)localIRuleGroup.createChildNode("TestCaseLib");
          try
          {
            localTestCaseLib.loadDataFromExcel(localFile);
            localTestCaseLib.setModified(true);
            localTestCaseLib.updateViewer();
            localIRulePackage.updateTree();
          }
          catch (Exception localException)
          {
            this.a.getRulesManager().j().a(localException.getLocalizedMessage(), localException);
          }
        }
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.g.p
 * JD-Core Version:    0.6.0
 */