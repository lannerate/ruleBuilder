package com.flagleader.builder.actions.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.d.W;
import com.flagleader.export.PagesMessages;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.export.PageFieldModel;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ExportModel;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import java.util.Iterator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class h extends u
{
  public h(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  protected String e()
  {
    return "ExportModel";
  }

  public String a()
  {
    return "NewExportModel";
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
      this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
      ITreeNode localITreeNode = this.a.getProjectTree().a("ExportModel", localRulePackage.getExeRulePackageName().replace('.', '/') + ".jsp");
      if (localITreeNode != null)
      {
        ExportModel localExportModel = (ExportModel)localITreeNode;
        Object localObject2;
        if (localExportModel.getEnvionment().getModelExport() == null)
        {
          localObject1 = new String[0];
          if (localExportModel.getImportFile().length() > 0)
            localObject1 = localExportModel.getPreferences().getStringArray(localExportModel.getImportFile() + ".props");
          if (localObject1 == null)
            localObject1 = localExportModel.getPreferences().getStringArray("export.props");
          for (i = 0; i < localObject1.length; i++)
          {
            localObject2 = localExportModel.getPreferences().getString(localObject1[i] + ".default", "");
            if (((String)localObject2).length() <= 0)
              continue;
            localExportModel.setPropertyValue(localObject1[i], (String)localObject2);
          }
        }
        localExportModel.setModified(true);
        Object localObject1 = localExportModel.getEnvionment().getAllMappingVariable();
        int i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MappingVariable)((Iterator)localObject1).next();
          if (localExportModel.getPageField(((MappingVariable)localObject2).getVariableName()) != null)
            continue;
          PageFieldModel localPageFieldModel = localExportModel.addMappingVariable((MappingVariable)localObject2);
          W.a(localPageFieldModel, localPageFieldModel.getInputType());
          W.a(localPageFieldModel, localPageFieldModel.getResultType());
          i = 1;
        }
        if (i != 0)
        {
          localExportModel.setModified(true);
          localExportModel.updateViewer();
        }
      }
      this.a.getShell().setCursor(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.a.h
 * JD-Core Version:    0.6.0
 */