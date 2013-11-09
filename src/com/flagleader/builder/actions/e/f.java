package com.flagleader.builder.actions.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.c.b;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.excel.ExcelXYSheetModel;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.widgets.Shell;

public class f extends a
{
  public f(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof ExcelBookModel)))
    {
      ExcelBookModel localExcelBookModel = (ExcelBookModel)paramITreeNode;
      b localb = new b(new Shell(), localExcelBookModel);
      if (localb.open() == 0)
      {
        ExcelXYSheetModel localExcelXYSheetModel = localExcelBookModel.createExcelXYSheet(localb.b(), localExcelBookModel.getVarTableName(localb.a()), localb.c(), localb.d(), localb.e(), localb.f());
        localExcelBookModel.updateTree();
        localExcelBookModel.updateViewer();
      }
    }
  }

  public String a()
  {
    return "NewExcelXYSheet";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.e.f
 * JD-Core Version:    0.6.0
 */