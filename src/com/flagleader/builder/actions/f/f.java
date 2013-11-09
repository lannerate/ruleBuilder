package com.flagleader.builder.actions.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.d.W;
import com.flagleader.builder.dialogs.d.r;
import com.flagleader.repository.collections.k;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.export.PageFieldModel;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.xml.XmlNode;
import java.util.List;

public class f extends b
{
  public f(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (paramITreeNode.isLocked()) || (!(paramITreeNode instanceof IPage)))
      return;
    IPage localIPage = (IPage)paramITreeNode;
    r localr = new r(this.a.getShell(), new k(new k(new k(localIPage.getEnvionment().getAllMappingVariable(), localIPage.getEnvionment().getExcelBookModels()), localIPage.getEnvionment().getXmlNodes()), localIPage.getEnvionment().getSheetTables()));
    if (localr.open() == 0)
    {
      List localList = localr.a();
      int i = 0;
      for (int j = 0; j < localList.size(); j++)
      {
        Object localObject;
        PageFieldModel localPageFieldModel;
        if ((localList.get(j) instanceof MappingVariable))
        {
          localObject = (MappingVariable)localList.get(j);
          if (localIPage.getPageField(((MappingVariable)localObject).getVariableName()) != null)
            continue;
          localPageFieldModel = localIPage.addMappingVariable((MappingVariable)localObject);
          W.a(localPageFieldModel, localPageFieldModel.getInputType());
          W.a(localPageFieldModel, localPageFieldModel.getResultType());
          i = 1;
        }
        else if ((localList.get(j) instanceof ExcelBookModel))
        {
          localObject = (ExcelBookModel)localList.get(j);
          if (localIPage.getPageField(((ExcelBookModel)localObject).getVarValue()) != null)
            continue;
          localPageFieldModel = new PageFieldModel();
          localIPage.addChildElement(localPageFieldModel);
          localPageFieldModel.setVariableName(((ExcelBookModel)localObject).getVarValue());
          localPageFieldModel.setValueType(((ExcelBookModel)localObject).getValueType());
          localPageFieldModel.setDisplayName(((ExcelBookModel)localObject).getDisplayName());
          localPageFieldModel.setInputType("fileinput");
          W.a(localPageFieldModel, localPageFieldModel.getInputType());
          W.a(localPageFieldModel, localPageFieldModel.getResultType());
          i = 1;
        }
        else if ((localList.get(j) instanceof XmlNode))
        {
          localObject = (XmlNode)localList.get(j);
          if (localIPage.getPageField(((XmlNode)localObject).getVarValue()) != null)
            continue;
          localPageFieldModel = new PageFieldModel();
          localIPage.addChildElement(localPageFieldModel);
          localPageFieldModel.setVariableName(((XmlNode)localObject).getVarValue());
          localPageFieldModel.setValueType(((XmlNode)localObject).getValueType());
          localPageFieldModel.setDisplayName(((XmlNode)localObject).getDisplayName());
          localPageFieldModel.setInputType("bigtext");
          W.a(localPageFieldModel, localPageFieldModel.getInputType());
          W.a(localPageFieldModel, localPageFieldModel.getResultType());
          i = 1;
        }
        else
        {
          if (!(localList.get(j) instanceof SheetTable))
            continue;
          localObject = (SheetTable)localList.get(j);
          if (localIPage.getPageField(((SheetTable)localObject).getVarValue()) != null)
            continue;
          localPageFieldModel = new PageFieldModel();
          localIPage.addChildElement(localPageFieldModel);
          localPageFieldModel.setVariableName(((SheetTable)localObject).getVarValue());
          localPageFieldModel.setValueType(((SheetTable)localObject).getValueType());
          localPageFieldModel.setDisplayName(((SheetTable)localObject).getDisplayName());
          localPageFieldModel.setResultType("table");
          W.a(localPageFieldModel, localPageFieldModel.getInputType());
          W.a(localPageFieldModel, localPageFieldModel.getResultType());
          i = 1;
        }
      }
      if (i != 0)
      {
        localIPage.setModified(true);
        localIPage.updateViewer();
      }
    }
  }

  public String a()
  {
    return "InitFieldItem";
  }

  protected boolean d()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.f.f
 * JD-Core Version:    0.6.0
 */