package com.flagleader.builder.a.f;

import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.engine.MessageUtil;
import com.flagleader.manager.d.c;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.d.u;
import com.flagleader.repository.rlm.RuleSetToken;
import com.flagleader.repository.rlm.action.AssignToken;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.ILangToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rlm.lang.IStatementContainerToken;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rlm.lang.IVariableToken;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.RuleSet;
import com.flagleader.util.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.agilemore.agilegrid.Z;
import org.agilemore.agilegrid.au;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;

public class bQ extends aS
  implements IElementViewer
{
  private int f = 1;
  org.agilemore.agilegrid.e e;
  private HashMap g = new HashMap();
  private List q = null;
  private int[] r;
  private String[] s = null;
  private int t = 2;
  private int u = 0;

  public bQ(RuleSet paramRuleSet, Composite paramComposite, bu parambu)
  {
    super(paramRuleSet, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new bQ((RuleSet)this.c, paramComposite, this.a);
  }

  private RuleSet g()
  {
    return (RuleSet)this.c;
  }

  protected void h()
  {
    a(new ca(this));
    super.h();
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "export");
    super.a(paramToolBar);
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    e();
    this.e = new org.agilemore.agilegrid.e(localComposite, 537133826);
    GridData localGridData = new GridData(1808);
    localGridData.horizontalAlignment = 4;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.verticalAlignment = 4;
    localGridData.grabExcessVerticalSpace = true;
    this.e.setLayoutData(localGridData);
    cf localcf = new cf(this, this.e);
    Z localZ = new Z(localcf);
    localcf.a(localZ);
    this.e.a(new cd(this, this.e));
    this.e.a(localcf);
    this.e.a(new ce(this));
    this.e.a(new cc(this, this.e));
    this.e.a(new bR(this));
    this.e.addMouseListener(new bS(this));
    return localComposite;
  }

  public void e()
  {
    this.t = g().getMaxDeepin();
    this.r = new int[this.t];
    for (int i = 0; i < this.r.length; i++)
      this.r[i] = 1;
    this.q = null;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = g().getRuleAndSets();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof RuleSet))
      {
        a(0, (RuleSet)localObject, localArrayList);
      }
      else
      {
        if (!(localObject instanceof Rule))
          continue;
        a((Rule)localObject, localArrayList, 0);
      }
    }
    this.q = localArrayList;
    this.s = new String[this.t];
    for (int j = 0; j < this.s.length; j++)
      this.s[j] = "";
    for (j = 0; j < this.q.size(); j++)
    {
      bZ localbZ = (bZ)this.q.get(j);
      if (!StringUtil.isEmpty(this.s[localbZ.b]))
        continue;
      if ((localbZ.e instanceof IMultiConditionToken))
      {
        this.s[localbZ.b] = a((IMultiConditionToken)localbZ.e);
      }
      else
      {
        if (!(localbZ.e instanceof IMultiActionToken))
          continue;
        this.s[localbZ.b] = a((IMultiActionToken)localbZ.e);
      }
    }
  }

  private void a(int paramInt, RuleSet paramRuleSet, List paramList)
  {
    Iterator localIterator = paramRuleSet.getRuleAndSets();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof RuleSet))
      {
        a(paramInt + 1, (RuleSet)localObject, paramList);
      }
      else
      {
        if (!(localObject instanceof Rule))
          continue;
        a((Rule)localObject, paramList, paramInt + 1);
      }
    }
    paramList.add(new bZ(this.r[paramInt], paramInt, this.r[(this.t - 1)] - this.r[paramInt], 1, paramRuleSet.getRuleSetToken().getTestConditions()));
    this.r[paramInt] = this.r[(this.t - 1)];
  }

  private String a(IMultiConditionToken paramIMultiConditionToken)
  {
    List localList = paramIMultiConditionToken.getConditionList();
    String str = "";
    if ((localList.size() > 0) && (((IConditionToken)localList.get(0)).getFirstValue() != null))
    {
      str = ((IConditionToken)localList.get(0)).getFirstValue().getDisplayName();
      if ((localList.size() > 1) && (((IConditionToken)localList.get(1)).getFirstValue() != null) && (!((IConditionToken)localList.get(1)).getFirstValue().getDisplayName().equals(str)))
        str = "";
    }
    return str;
  }

  private String a(IMultiActionToken paramIMultiActionToken)
  {
    Iterator localIterator = paramIMultiActionToken.getActions();
    String str = "";
    if (localIterator.hasNext())
    {
      IStatementContainerToken localIStatementContainerToken = (IStatementContainerToken)localIterator.next();
      if ((!localIterator.hasNext()) && ((localIStatementContainerToken.getStatement() instanceof AssignToken)) && (((AssignToken)localIStatementContainerToken.getStatement()).getFirstValue() != null))
        str = ((AssignToken)localIStatementContainerToken.getStatement()).getFirstValue().getDisplayName();
    }
    return str;
  }

  private void a(Rule paramRule, List paramList, int paramInt)
  {
    List localList = paramRule.getRuleTableInfos();
    for (int i = 0; i < localList.size(); i++)
    {
      com.flagleader.repository.rlm.e locale = (com.flagleader.repository.rlm.e)localList.get(i);
      if (locale.b() != null)
        paramList.add(new bZ(this.r[(this.t - 2)], this.t - 2, 1, 1, locale.b()));
      else
        paramList.add(new bZ(this.r[(this.t - 2)], this.t - 2, 1, 1, locale.a()));
      if (locale.c() != null)
        paramList.add(new bZ(this.r[(this.t - 1)], this.t - 1, 1, 1, locale.c()));
      this.r[(this.t - 2)] += 1;
      this.r[(this.t - 1)] += 1;
      for (int j = paramInt; j < this.t - 2; j++)
        this.r[j] += 1;
    }
  }

  private void i()
  {
    for (int i = 0; i < this.t - 2; i++)
      this.r[i] += 1;
  }

  private int j()
  {
    return this.t;
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()))
      return;
    this.g.clear();
    e();
    this.e.update();
    this.e.redraw();
    super.update();
  }

  public boolean needUpdate()
  {
    return (this.d == 0L) || (this.d < g().getMaxModifyTime()) || (this.d < g().getEnvionment().getMaxModifyTime());
  }

  public String getCompositeUuid()
  {
    return g().getEditUuid() + "table";
  }

  void f()
  {
    FileDialog localFileDialog = new FileDialog(new Shell(), 8192);
    localFileDialog.setFilterExtensions(new String[] { "*.xls", "*.xlsx" });
    localFileDialog.setFileName(g().getDisplayName());
    if (localFileDialog.open() != null)
      try
      {
        Object localObject = null;
        if (localFileDialog.getFileName().endsWith(".xls"))
          localObject = new HSSFWorkbook();
        else
          localObject = new XSSFWorkbook();
        a((Workbook)localObject);
        File localFile = new File(localFileDialog.getFilterPath() + File.separator + localFileDialog.getFileName());
        if (!localFile.exists())
          localFile.createNewFile();
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        ((Workbook)localObject).write(localFileOutputStream);
        localFileOutputStream.flush();
        localFileOutputStream.close();
        MessageDialog.openInformation(new Shell(), "", c.a("HasBeenExport", new String[] { localFileDialog.getFilterPath() + File.separator + localFileDialog.getFileName() }));
      }
      catch (IOException localIOException)
      {
        MessageDialog.openError(new Shell(), "file error!", localIOException.getMessage());
      }
  }

  private Workbook a(Workbook paramWorkbook)
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
    localSheet = paramWorkbook.createSheet(g().getDisplayName());
    a(localSheet, localCellStyle);
    return paramWorkbook;
  }

  private Cell a(Row paramRow, int paramInt, CellStyle paramCellStyle)
  {
    Cell localCell = paramRow.createCell(paramInt);
    localCell.setCellStyle(paramCellStyle);
    return localCell;
  }

  private void a(Row paramRow, CellStyle paramCellStyle)
  {
    for (int i = 0; i < this.t; i++)
    {
      if (paramRow.getCell(i) == null)
        continue;
      paramRow.getCell(i).setCellStyle(paramCellStyle);
    }
  }

  private Row a(Sheet paramSheet, int paramInt)
  {
    if (paramSheet.getRow(paramInt) != null)
      return paramSheet.getRow(paramInt);
    return paramSheet.createRow(paramInt);
  }

  private String a(ILangToken paramILangToken)
  {
    String str = paramILangToken.getText();
    str = StringUtil.replace("\r", "", str);
    if (str.endsWith("\n"))
      return str.substring(0, str.length() - "\n".length());
    return str;
  }

  public void a(Sheet paramSheet, CellStyle paramCellStyle)
  {
    this.u = 0;
    Row localRow1 = paramSheet.createRow(this.u++);
    localRow1.createCell(0).setCellValue(u.a("tv_condition"));
    localRow1.createCell(this.t - 2).setCellValue(u.a("tv_if"));
    localRow1.createCell(this.t - 1).setCellValue(u.a("tv_action"));
    a(localRow1, paramCellStyle);
    for (int i = 0; i < this.q.size(); i++)
    {
      localRow1 = paramSheet.createRow(this.u++);
      bZ localbZ = (bZ)this.q.get(i);
      Row localRow2 = a(paramSheet, localbZ.a + 1);
      if ((localbZ.e instanceof ILangToken))
        localRow2.createCell(localbZ.b).setCellValue(a((ILangToken)localbZ.e));
      else
        localRow2.createCell(localbZ.b).setCellValue(StringUtil.stringValue(localbZ.e));
      localRow2.getCell(localbZ.b).setCellStyle(paramCellStyle);
      if (localbZ.d <= 1)
        continue;
      paramSheet.addMergedRegion(new CellRangeAddress(localbZ.a + 1, localbZ.a + localbZ.d, (short)localbZ.b, (short)localbZ.b));
    }
    for (i = 0; i < this.t; i = (short)(i + 1))
      paramSheet.autoSizeColumn(i);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bQ
 * JD-Core Version:    0.6.0
 */