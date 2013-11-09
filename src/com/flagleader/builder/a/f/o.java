package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.engine.MessageUtil;
import com.flagleader.manager.a;
import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import org.agilemore.agilegrid.Z;
import org.agilemore.agilegrid.au;
import org.agilemore.agilegrid.e;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;

public class o extends aS
  implements IElementViewer
{
  private int f = 1;
  e e;
  private List g = null;
  private HashMap q = new HashMap();

  public o(DecisionRelateRule paramDecisionRelateRule, Composite paramComposite, bu parambu)
  {
    super(paramDecisionRelateRule, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new o((DecisionRelateRule)this.c, paramComposite, this.a);
  }

  private DecisionRelateRule g()
  {
    return (DecisionRelateRule)this.c;
  }

  protected void h()
  {
    a(new H(this));
    a(new K(this));
    a(new L(this));
    a(new I(this));
    a(new J(this));
    a(new W(this));
    super.h();
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "add");
    a(paramToolBar, "import");
    a(paramToolBar, "export");
    a(paramToolBar, "AddValue");
    super.a(paramToolBar);
    a(paramToolBar, "AllowSheet");
    a(paramToolBar, "RuleOrder");
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    this.e = new e(localComposite, 537133826);
    GridData localGridData = new GridData(1808);
    localGridData.horizontalAlignment = 4;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.verticalAlignment = 4;
    localGridData.grabExcessVerticalSpace = true;
    this.e.setLayoutData(localGridData);
    V localV = new V(this, this.e);
    Z localZ = new Z(localV);
    localV.a(localZ);
    this.e.a(new S(this, this.e));
    this.e.a(localV);
    this.e.a(new U(this));
    this.e.a(new N(this, this.e));
    this.e.a(new p(this));
    this.e.addMouseListener(new q(this));
    return localComposite;
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()))
      return;
    if ((!this.c.isLocked()) && (a().getConfigManager().E()))
      a().getRulesManager().c().a(g());
    this.g = g().getLineInfos();
    this.q.clear();
    this.e.update();
    this.e.redraw();
    for (int i = 0; i < g().getConditionNum() + g().getValueNum() + 1; i++)
      this.e.h(i);
    super.update();
  }

  public boolean needUpdate()
  {
    return (this.d == 0L) || (this.d < g().getMaxModifyTime()) || (this.d < g().getEnvionment().getMaxModifyTime());
  }

  public String getCompositeUuid()
  {
    return g().getEditUuid() + "value";
  }

  public List e()
  {
    if (this.g == null)
      this.g = g().getLineInfos();
    return this.g;
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
    g().exportExcelSheet(localSheet, localCellStyle);
    return paramWorkbook;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.o
 * JD-Core Version:    0.6.0
 */