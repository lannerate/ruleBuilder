package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.a.v;
import com.flagleader.repository.a.a;
import com.flagleader.repository.export.d;
import com.flagleader.util.filesystem.FileUtil;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class aC
{
  private static Menu a;

  public static void a(d paramd, Exception paramException, String paramString)
  {
    Shell localShell = new Shell();
    Display localDisplay = localShell.getDisplay();
    String str1 = "";
    if ((paramException instanceof a))
    {
      str1 = paramException.getMessage();
    }
    else
    {
      localObject1 = new StringWriter();
      paramException.printStackTrace(new PrintWriter((Writer)localObject1));
      str1 = ((StringWriter)localObject1).toString();
    }
    localShell.setText(paramString);
    Object localObject1 = new GridLayout();
    ((GridLayout)localObject1).numColumns = 1;
    ((GridLayout)localObject1).marginHeight = 0;
    ((GridLayout)localObject1).marginWidth = 0;
    ((GridLayout)localObject1).horizontalSpacing = 0;
    ((GridLayout)localObject1).verticalSpacing = 0;
    localShell.setLayout((Layout)localObject1);
    localShell.setLayoutData(new GridData(1808));
    SashForm localSashForm = new SashForm(localShell, 512);
    localSashForm.setLayoutData(new GridData(1808));
    String str2 = paramd.k();
    StyledText localStyledText1 = new v(localSashForm, 2818).m();
    localStyledText1.setText(str2);
    localStyledText1.addMouseListener(new aD(localStyledText1));
    StyledText localStyledText2 = new StyledText(localSashForm, 2818);
    localStyledText2.setText(str1);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new StringTokenizer(str1, FileUtil.newline);
    while (((StringTokenizer)localObject2).hasMoreTokens())
      localArrayList.add(((StringTokenizer)localObject2).nextToken());
    localObject2 = new ArrayList();
    Object localObject3 = new StringTokenizer(str2, FileUtil.newline);
    while (((StringTokenizer)localObject3).hasMoreTokens())
      ((ArrayList)localObject2).add(((StringTokenizer)localObject3).nextToken());
    localObject3 = new ArrayList(localArrayList.size());
    for (int i = 0; i < localArrayList.size(); i++)
    {
      localObject4 = localArrayList.get(i).toString();
      if (((String)localObject4).indexOf(".java:") > 0)
      {
        int j = ((String)localObject4).indexOf(":", ((String)localObject4).indexOf(".java:") + 6);
        if (j < 0)
          j = ((String)localObject4).indexOf(")", ((String)localObject4).indexOf(".java:") + 6);
        if (j < 0)
          continue;
        localObject5 = ((String)localObject4).substring(((String)localObject4).indexOf(".java:") + 6, j);
        try
        {
          ((ArrayList)localObject3).add(new Integer(localStyledText1.getOffsetAtLine(Integer.parseInt((String)localObject5) - 1)));
        }
        catch (Exception localException)
        {
          ((ArrayList)localObject3).add(new Integer(-1));
        }
      }
      else
      {
        ((ArrayList)localObject3).add(new Integer(-1));
      }
    }
    localStyledText2.addMouseMoveListener(new aI(localStyledText2, (ArrayList)localObject3));
    localStyledText2.addMouseListener(new aJ(localStyledText2, (ArrayList)localObject3, localStyledText1));
    localSashForm.setWeights(new int[] { 80, 20 });
    Menu localMenu1 = new Menu(localShell, 2);
    localShell.setMenuBar(localMenu1);
    Object localObject4 = new MenuItem(localMenu1, 64);
    ((MenuItem)localObject4).setText(ResourceTools.getMessage("EditMenu"));
    Menu localMenu2 = new Menu(localMenu1);
    Object localObject5 = new MenuItem(localMenu2, 8);
    ((MenuItem)localObject5).setText(ResourceTools.getMessage("SelectAllItem"));
    ((MenuItem)localObject5).setAccelerator(SWT.MOD1 + 65);
    ((MenuItem)localObject5).addSelectionListener(new aK(localStyledText1, localStyledText2));
    MenuItem localMenuItem1 = new MenuItem(localMenu2, 8);
    localMenuItem1.setText(ResourceTools.getMessage("CutItem"));
    localMenuItem1.setAccelerator(SWT.MOD1 + 88);
    localMenuItem1.addSelectionListener(new aL(localStyledText1, localStyledText2));
    localMenuItem1 = new MenuItem(localMenu2, 8);
    localMenuItem1.setText(ResourceTools.getMessage("CopyItem"));
    localMenuItem1.setAccelerator(SWT.MOD1 + 67);
    localMenuItem1.addSelectionListener(new aM(localStyledText1, localStyledText2));
    localMenuItem1 = new MenuItem(localMenu2, 8);
    localMenuItem1.setText(ResourceTools.getMessage("PasteItem"));
    localMenuItem1.setAccelerator(SWT.MOD1 + 86);
    localMenuItem1.addSelectionListener(new aN(localStyledText1, localStyledText2));
    MenuItem localMenuItem2 = new MenuItem(localMenu2, 8);
    localMenuItem2.setText(ResourceTools.getMessage("PrintItem"));
    localMenuItem2.setAccelerator(SWT.MOD1 + 80);
    localMenuItem2.addSelectionListener(new aO(localStyledText1, localStyledText2));
    localMenuItem1 = new MenuItem(localMenu2, 2);
    MenuItem localMenuItem3 = new MenuItem(localMenu2, 8);
    localMenuItem3.setText(ResourceTools.getMessage("ExitItem"));
    localMenuItem3.addSelectionListener(new aP(localShell));
    ((MenuItem)localObject4).setMenu(localMenu2);
    localShell.pack();
    localShell.setSize(800, 600);
    localShell.open();
    while (!localShell.isDisposed())
    {
      if (localDisplay.readAndDispatch())
        continue;
      localDisplay.sleep();
    }
    localShell.dispose();
  }

  private static int a(String paramString)
  {
    int i = paramString.indexOf(":", paramString.indexOf(".java:") + 6);
    if (i < 0)
      i = paramString.indexOf(")", paramString.indexOf(".java:") + 6);
    try
    {
      if (i >= 0)
      {
        String str = paramString.substring(paramString.indexOf(".java:") + 6, i);
        return Integer.parseInt(str);
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return -1;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.aC
 * JD-Core Version:    0.6.0
 */