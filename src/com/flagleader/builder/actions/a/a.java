package com.flagleader.builder.actions.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.d.W;
import com.flagleader.export.PagesMessages;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.export.AjaxPage;
import com.flagleader.repository.export.PageFieldModel;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import java.util.Iterator;

public class a extends u
{
  public a(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  protected String e()
  {
    return "AjaxPage";
  }

  public String a()
  {
    return "NewAjaxPage";
  }

  protected boolean d()
  {
    return true;
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof RulePackage)))
    {
      RulePackage localRulePackage = (RulePackage)paramITreeNode;
      ITreeNode localITreeNode = this.a.getProjectTree().a("AjaxPage", localRulePackage.getExeRulePackageName().replace('.', '/') + ".jsp");
      if (localITreeNode != null)
      {
        AjaxPage localAjaxPage = (AjaxPage)localITreeNode;
        Object localObject2;
        if (localAjaxPage.getEnvionment().getModelExport() == null)
        {
          localObject1 = new String[0];
          if (localAjaxPage.getImportFile().length() > 0)
            localObject1 = localAjaxPage.getPreferences().getStringArray(localAjaxPage.getImportFile() + ".props");
          if (localObject1 == null)
            localObject1 = localAjaxPage.getPreferences().getStringArray("export.props");
          for (i = 0; i < localObject1.length; i++)
          {
            localObject2 = localAjaxPage.getPreferences().getString(localObject1[i] + ".default", "");
            if (((String)localObject2).length() <= 0)
              continue;
            localAjaxPage.setPropertyValue(localObject1[i], (String)localObject2);
          }
        }
        localAjaxPage.setModified(true);
        Object localObject1 = localAjaxPage.getEnvionment().getAllMappingVariable();
        int i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MappingVariable)((Iterator)localObject1).next();
          if (localAjaxPage.getPageField(((MappingVariable)localObject2).getVariableName()) != null)
            continue;
          PageFieldModel localPageFieldModel = localAjaxPage.addMappingVariable((MappingVariable)localObject2);
          W.a(localPageFieldModel, localPageFieldModel.getInputType());
          W.a(localPageFieldModel, localPageFieldModel.getResultType());
          i = 1;
        }
        if (i != 0)
        {
          localAjaxPage.setModified(true);
          localAjaxPage.updateViewer();
        }
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.a.a
 * JD-Core Version:    0.6.0
 */