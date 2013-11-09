package com.flagleader.builder.actions.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.excel.ExcelSheetModel;
import com.flagleader.repository.tree.ITreeNode;
import java.util.List;
import org.eclipse.swt.widgets.Shell;

public abstract class a extends bl
{
  public a(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof ExcelBookModel;
  }

  protected boolean d()
  {
    return true;
  }

  public void a(ITreeNode paramITreeNode, String paramString, List paramList)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof ExcelBookModel)))
    {
      ExcelBookModel localExcelBookModel = (ExcelBookModel)paramITreeNode;
      com.flagleader.builder.dialogs.c.a locala = new com.flagleader.builder.dialogs.c.a(new Shell(), localExcelBookModel);
      if (locala.open() == 0)
      {
        ExcelSheetModel localExcelSheetModel = localExcelBookModel.createExcelSheet(locala.b(), localExcelBookModel.getVarTableName(locala.a()), locala.c());
        localExcelBookModel.updateTree();
        localExcelBookModel.updateViewer();
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.e.a
 * JD-Core Version:    0.6.0
 */