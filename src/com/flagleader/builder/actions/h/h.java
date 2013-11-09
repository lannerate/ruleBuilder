package com.flagleader.builder.actions.h;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.e.d;
import com.flagleader.engine.MessageUtil;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRule;
import com.flagleader.repository.tree.ITreeNode;
import java.util.List;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class h extends bl
{
  public h(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof IPackageElement;
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (!(paramITreeNode instanceof IPackageElement))
      return;
    FileDialog localFileDialog = new FileDialog(new Shell(), 8192);
    localFileDialog.setFilterExtensions(new String[] { "*.xls", "*.xlsx" });
    localFileDialog.setFileName(paramITreeNode.getDisplayName());
    String str = localFileDialog.open();
    if (str != null)
    {
      d locald = new d(this.a, paramITreeNode);
      if (locald.open() == 0)
      {
        List localList = locald.a();
        this.a.getRulesManager().l().b((IPackageElement)paramITreeNode, str, localList, true);
      }
    }
  }

  private Workbook a(Workbook paramWorkbook, ITreeNode paramITreeNode)
  {
    Sheet localSheet = null;
    Font localFont = paramWorkbook.createFont();
    localFont.setFontName(MessageUtil.getString("excelDefaultFontName"));
    localFont.setFontHeightInPoints(12);
    CellStyle localCellStyle = paramWorkbook.createCellStyle();
    localCellStyle.setBorderBottom(1);
    localCellStyle.setBorderLeft(1);
    localCellStyle.setBorderRight(1);
    localCellStyle.setBorderTop(1);
    localCellStyle.setFont(localFont);
    localCellStyle.setWrapText(true);
    d locald = new d(this.a, paramITreeNode);
    if (locald.open() == 0)
    {
      List localList = locald.a();
      for (int i = 0; i < localList.size(); i++)
      {
        if (!(localList.get(i) instanceof IRule))
          continue;
        try
        {
          localSheet = paramWorkbook.createSheet(((IRule)localList.get(i)).getDisplayName());
          ((IRule)localList.get(i)).exportExcelSheet(localSheet, localCellStyle);
        }
        catch (Exception localException)
        {
          this.a.showError(c.a("error.checkin", new String[] { localException.getMessage() }));
        }
      }
    }
    return paramWorkbook;
  }

  public String a()
  {
    return "ExportRuleExcel";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.h.h
 * JD-Core Version:    0.6.0
 */